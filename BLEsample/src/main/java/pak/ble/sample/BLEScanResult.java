package pak.ble.sample;

import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by a2800276 on 31/03/14.
 */
public class BLEScanResult implements Comparable <BLEScanResult> {

    long    lastSeen;
    // will be marked as old before new scan.
    boolean old;

    BluetoothDevice device;
    int rssi;
    BLEAdvertisingData record;


    public BLEScanResult(BluetoothDevice d, int rssi, byte [] rec) {
        this.device = d;
        this.rssi   = rssi;
        this.record = new BLEAdvertisingData(rec);
        this.lastSeen = System.currentTimeMillis();
    }

    @Override
    public String toString() {

        return "BLEScanResult{" +
                "device=" + device +
                ", name=" + getName() +
                ", rssi=" + rssi +
                ", record=" + record.getFormattedBytes() +
                '}';
    }

    public String getName() {
        return device.getName() == null ? "unknown" : device.getName();
    }

    public String getAdvertisement () {
        return record.getFormattedBytes();
    }

    public String getRSSI () {
            return Integer.toString(rssi);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BLEScanResult that = (BLEScanResult) o;

        //if (!device.equals(that.device)) return false;
        if (!that.device.getAddress().equals(this.device.getAddress())) {
            return false;
        }
        return Arrays.equals(record.bytes, that.record.bytes);

    }

    @Override
    public int hashCode() {
        int result = device.hashCode();
        result = 31 * result + record.hashCode();
        return result;
    }

    static String TAG = BLEScanResult.class.getSimpleName();

    static void e (String mes) {
        Log.e(TAG, mes);
    }
    static void d (String mes) {
        Log.d(TAG, mes);
    }

    @Override
    public int compareTo(BLEScanResult bleScanResult) {
        // if one or the other wasn't seen since the  last scan ....
        if (this.old && !bleScanResult.old) return 1;
        if (bleScanResult.old && !this.old) return -1;
        // else sort by strength
        if (this.rssi == bleScanResult.rssi) return 0;
        if (this.rssi > bleScanResult.rssi) return -1;
        return 1;
    }
}
