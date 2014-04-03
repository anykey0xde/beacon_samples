package pak.ble.sample;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by a2800276 on 31/03/14.
 */
public class BLEAdvertisingData {
    byte[] bytes;
    List<AdvertisementEntry> entries;


    public BLEAdvertisingData(byte [] bytes) {
        this.bytes = bytes;
        entries = new LinkedList<AdvertisementEntry>();
        parse();
    }

    void parse() {
        // BLE AD data is described in BT 4.0 v3 Part C(GAP) Sec. 11
        // |LEN (1byte) | AD Type (1 byte) | value |
        for (int i = 0; i< bytes.length ;) {
            int len = bytes[i] & 0xff;
            if (len == 0) break;
            Log.d("", "" + len);
            if ((i + len) >= bytes.length) { /* data invalid */}
            ++i;
            byte    type = bytes[i];
            ++i;
            byte [] data = new byte[len-1];
            System.arraycopy(bytes, i, data, 0, len-1);
            i+=len-1;
            entries.add(new AdvertisementEntry(type, data));
        }
    }
    String getFormattedBytes () {
        return BLEUtils.toHex(bytes);
    }

    static String mapData(byte type, byte[]entry) {
        switch (type) {
            case 0x01: return BLEConstants.advertisingFlagsToString(entry);
            case 0x08:
            case 0x09:
                    return new String(entry);
            default: return BLEUtils.toHex(entry);
        }
    }


    class AdvertisementEntry {
        byte type;
        byte[] data;
        public AdvertisementEntry(byte t, byte[] data) {
            this.type = t;
            this.data = data;
        }
        public String toString() {
            return BLEConstants.advertisingTypeToString(type) + ":\n" + mapData(type, data);
        }
    }
}

//0x01 Flags
//0x02 Incomplete List of 16-bit Service Class UUIDs
//0x03 Complete List of 16-bit Service Class UUIDs
//0x04 Incomplete List of 32-bit Service Class UUIDs
//0x05 Complete List of 32-bit Service Class UUIDs
//0x06 Incomplete List of 128-bit Service Class UUIDs
//0x07 Complete List of 128-bit Service Class UUIDs
//0x08 Shortened Local Name
//0x09 Complete Local Name
//0x0A Tx Power Level
//0x0D Class of Device
//0x0E Simple Pairing Hash C
//0x0F Simple Pairing Randomizer R
//0x10 Security Manager TK Value
//0x11 Security Manager Out of Band Flags
//0x12 Slave Connection Interval Range
//0x14 List of 16-bit Service Solicitation UUIDs
//0x15 List of 128-bit Service Solicitation UUIDs
//0x16 Service Data
//0x20 Service Data - 32-bit UUID
//0x21 Service Data - 128-bit UUID
//0x17 Public Target Address
//0x18 Random Target Address
//0x19 Appearance
//0x1A Advertising Interval
//0x1B LE Bluetooth Device Address
//0x1C LE Role
//0x1D Simple Pairing Hash C-256
//0x1E Simple Pairing Randomizer R-256
//0x3D 3D Information Data
//0xFF Manufacturer Specific Data
