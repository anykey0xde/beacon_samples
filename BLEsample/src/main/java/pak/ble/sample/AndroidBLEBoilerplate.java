package pak.ble.sample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by a2800276 on 31/03/14.
 */
public class AndroidBLEBoilerplate {



    static final int  ENABLE_BT_ACTIVITY = 1;
    static final long SCAN_TIME = 2000;


    Map<String, BLEScanResult> bleScanResultMap;

    boolean scanning;

    MainActivity     activity;
    BluetoothManager btManager;
    BluetoothAdapter btAdapter;

    final Handler handler;

    static AndroidBLEBoilerplate areYouShittingMeYouSeriouslyExpectMeToCreateASingletonHere;

    public static AndroidBLEBoilerplate getBLE() {
        if (areYouShittingMeYouSeriouslyExpectMeToCreateASingletonHere == null) {
            areYouShittingMeYouSeriouslyExpectMeToCreateASingletonHere = new AndroidBLEBoilerplate();
        }
        return areYouShittingMeYouSeriouslyExpectMeToCreateASingletonHere;
    }

    private AndroidBLEBoilerplate() {
        this.handler = new Handler();
        // this is used to buffer results in between invocations.
        this.bleScanResultMap = new HashMap<String, BLEScanResult>();

    }
    /**
     * Set reference to Gemischtwarenladen
     * */
    void setActivity (MainActivity activity) {
        this.activity = activity;
    }

    boolean initialized;
    boolean init() {
        if (initialized) {
            return true;
        } else {
            initialized = true;
        }

        PackageManager pm = this.activity.getPackageManager();
        if (!pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)){
            e("This device does not have a BLE feature.");
            return false;
        }



        // Initializes a Bluetooth adapter.  For API level 18 and above, get a reference to
        // BluetoothAdapter through BluetoothManager.
        btManager = (BluetoothManager) this.activity.getSystemService(Context.BLUETOOTH_SERVICE);
        btAdapter  = btManager.getAdapter();

        // Checks if Bluetooth is supported on the device.
        if (btAdapter == null) {
            e("Could not create an adapter");
            return false;
        }
        return true;
    }

    /**
     * the corresponding Activity must have a `onActivityResult` function to receive the
     * result of ENABLE_BT_ACTIVITY ...
     */
    void checkBLEEnabled() {
        if (!btAdapter.isEnabled()) {
            Intent enBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            this.activity.startActivityForResult(enBtIntent, ENABLE_BT_ACTIVITY);
        }
    }



    BluetoothAdapter.LeScanCallback scanCB = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {

            final BLEScanResult result = new BLEScanResult(bluetoothDevice, i, bytes);
            d(result.toString());

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    bleScanResultMap.put(result.device.getAddress(), result);
                    activity.bleAdapter.notifyDataSetChanged();
                }
            });
        }
    };

    void scan() {
        if (scanning) {
            d("asked to start scanning, but not feeling up to it.");
            this.activity.invalidateOptionsMenu();
            return;
        }
        d("starting scan.");
        //bleScanResultList = new LinkedList<BLEScanResult>();

        checkBLEEnabled();

        // mark all the previously found devices as old so we can grey them out or whatever.
        this.activity.runOnUiThread( new Runnable() {
            @Override
            public void run() {
                for (BLEScanResult r : bleScanResultMap.values()) {
                    r.old = true;
                }
            }
        });

        // stop after a set amount of time.
        this.handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stopScan();
            }
        }, SCAN_TIME);

        btAdapter.startLeScan(scanCB);
        this.scanning = true;
        this.activity.invalidateOptionsMenu();
    }

    void stopScan() {
        if (!scanning) {
            d("asked to stop scanning, but don't recall starting to.");
            this.activity.invalidateOptionsMenu();
            return;
        }
        d("stopping scan.");
        checkBLEEnabled();

        // throw out expired entries.
        throwOutExpiredDevices();
        btAdapter.stopLeScan(scanCB);
        this.scanning = false;
        this.activity.invalidateOptionsMenu();
    }

    // throw out entries older than this long (15 minutes)
    static final long CLEAR_INTERVAL = 1000 * 60 * 15;

    void throwOutExpiredDevices() {
        long now = System.currentTimeMillis();
        // oh, the sheer elegance and beauty of Java...
        Iterator<Map.Entry<String,BLEScanResult>> iter = bleScanResultMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, BLEScanResult> entry = iter.next();
            if  ((now - entry.getValue().lastSeen) > CLEAR_INTERVAL) {
                iter.remove();
            }
        }
    }







    static String TAG = AndroidBLEBoilerplate.class.getSimpleName();

    static void e (String mes) {
        Log.e(TAG, mes);
    }
    static void d (String mes) {
        Log.d(TAG, mes);
    }


}
