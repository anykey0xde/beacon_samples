package pak.ble.sample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by a2800276 on 31/03/14.
 */
public class BLEAdvertisingData {
    byte[] bytes;
    boolean valid;
    List<AdvertisementEntry> entries;


    public BLEAdvertisingData(byte [] bytes) {
        this.bytes = bytes;
        entries = new LinkedList<AdvertisementEntry>();
        //parse();
    }

    void parse() {
        // BLE AD data is described in BT 4.0 v3 Part C(GAP) Sec. 11
        // |LEN (1byte) | AD Type (1 byte) | value |
        for (int i = 0; i< bytes.length ;) {
            int len = bytes[i] & 0xff;
            if ((i + len) >= bytes.length) { /* data invalid */}
            ++i;
            byte    type = bytes[i];
            ++i;
            byte [] data = new byte[len-1];
            System.arraycopy(bytes, i, data, 0, len-1);
            entries.add(new AdvertisementEntry(type, data));
        }
    }
    String getFormattedBytes () {
        return toHex(bytes);
    }

    static String mapType (byte type) {
        // https://www.bluetooth.org/en-us/specification/assigned-numbers/generic-access-profile
        switch (type & 0xff) {
            case 0x01: return "Flags";
            case 0x02: return "Incomplete List of 16-bit Service Class UUIDs";
            case 0x03: return "Complete List of 16-bit Service Class UUIDs";
            case 0x04: return "Incomplete List of 32-bit Service Class UUIDs";
            case 0x05: return "Complete List of 32-bit Service Class UUIDs";
            case 0x06: return "Incomplete List of 128-bit Service Class UUIDs";
            case 0x07: return "Complete List of 128-bit Service Class UUIDs";
            case 0x08: return "Shortened Local Name";
            case 0x09: return "Complete Local Name";
            case 0x0A: return "Tx Power Level";
            case 0x0D: return "Class of Device";
            case 0x0E: return "Simple Pairing Hash C";
            case 0x0F: return "Simple Pairing Randomizer R";
            case 0x10: return "Security Manager TK Value";
            case 0x11: return "Security Manager Out of Band Flags";
            case 0x12: return "Slave Connection Interval Range";
            case 0x14: return "List of 16-bit Service Solicitation UUIDs";
            case 0x15: return "List of 128-bit Service Solicitation UUIDs";
            case 0x16: return "Service Data";
            case 0x20: return "Service Data - 32-bit UUID";
            case 0x21: return "Service Data - 128-bit UUID";
            case 0x17: return "Public Target Address";
            case 0x18: return "Random Target Address";
            case 0x19: return "Appearance";
            case 0x1A: return "Advertising Interval";
            case 0x1B: return "LE Bluetooth Device Address";
            case 0x1C: return "LE Role";
            case 0x1D: return "Simple Pairing Hash C-256";
            case 0x1E: return "Simple Pairing Randomizer R-256";
            case 0x3D: return "3D Information Data";
            case 0xFF: return "Manufacturer Specific Data";

            default: return "unknown";
        }
    }

    private String toHex(byte [] bytes) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i != bytes.length; ++i){
            if (i%8 == 0 && i!= 0) {
                sb.append("\n");
            }
            String s = Integer.toHexString(bytes[i] & 0xff);
            if (s.length() == 1) {
                sb.append('0');
            }
            sb.append(s);
            sb.append(" ");


        }
        return sb.toString();
    }



    class AdvertisementEntry {
        byte type;
        byte[] data;
        public AdvertisementEntry(byte t, byte[] data) {
            this.type = t;
            this.data = data;
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
