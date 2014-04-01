package pak.ble.sample;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by a2800276 on 31/03/14.
 */
public class AndroidBLEBoilerplate {



    static final int ENABLE_BT_ACTIVITY = 1;
    private static final long SCAN_TIME = 10000;


    List<BLEScanResult> bleScanResultList;

    Activity activity;
    BluetoothManager btManager;
    BluetoothAdapter btAdapter;
    final Handler handler;

    public AndroidBLEBoilerplate() {
        this.handler = new Handler();
        this.bleScanResultList = new LinkedList<BLEScanResult>();

    }
    /**
     * Set reference to Gemischtwarenladen
     * */
    void setActivity (Activity activity) {
        this.activity = activity;
    }

    boolean init() {
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

            BLEScanResult result = new BLEScanResult(bluetoothDevice, i, bytes);
            d(result.toString());
            // Store locally ...
            bleScanResultList.remove(result);
            bleScanResultList.add(result);
            // give back to activity ..
            ((MainActivity)activity).updateUI(result);




        }
    };

    void scan() {
        d("starting scan.");
        bleScanResultList = new LinkedList<BLEScanResult>();
        ((MainActivity)activity).updateUIClearBLEList();
        this.handler.postDelayed( new Runnable () {
            @Override
            public void run() {
                stopScan();
                // tell activity we're done ... or inform about new devices in callback ... ?
                for (BLEScanResult r : bleScanResultList) {
                    d(r.toString());
                }
            }
        }, SCAN_TIME);
        checkBLEEnabled();
        btAdapter.startLeScan(scanCB);

    }
    void stopScan() {
        d("stopping scan.");
        checkBLEEnabled();
        btAdapter.stopLeScan(scanCB);
    };

    static String TAG = AndroidBLEBoilerplate.class.getSimpleName();

    static void e (String mes) {
        Log.e(TAG, mes);
    }
    static void d (String mes) {
        Log.d(TAG, mes);
    }
}
