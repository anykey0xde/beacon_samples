package pak.ble.sample;

/**
 * Created by a2800276 on 03/04/14.
 */
public class BLEConstants {

    static final int FLAG_LE_LIMITED_DISCOVERY_MODE   = 1;
    static final int FLAG_LE_GENERAL_DICOVERY_MODE    = 1 << 1;
    static final int FLAG_BR_EDR_NOT_SUPPORTED        = 1 << 2;
    static final int FLAG_SIMULTANEOUS_LE_BR_EDR_CTL  = 1 << 3;
    static final int FLAG_SIMULTANEOUS_LE_BR_EDR_HOST = 1 << 4;

    public static String advertisingFlagsToString (byte [] flags) {
        StringBuilder builder = new StringBuilder();
        int flagI = flags[0] & 0xff;
        if ((flagI & FLAG_LE_LIMITED_DISCOVERY_MODE) != 0) {
            builder.append("LE Limited Discoverable Mode\n");
        }
        if ((flagI & FLAG_LE_GENERAL_DICOVERY_MODE) != 0) {
            builder.append("LE General Discoverable Mode\n");
        }
        if ((flagI & FLAG_BR_EDR_NOT_SUPPORTED) != 0) {
            builder.append("SBR/EDR Not Supported.\n");
        }
        if ((flagI & FLAG_SIMULTANEOUS_LE_BR_EDR_CTL) != 0) {
            builder.append("LSimultaneous LE and BR/EDR to Same" +
                    "Device Capable (Controller).\n");
        }
        if ((flagI & FLAG_SIMULTANEOUS_LE_BR_EDR_HOST) != 0) {
            builder.append("Simultaneous LE and BR/EDR to Same" +
                    "Device Capable (Host)\n");
        }
        return builder.toString();
    }

    public static byte BLE_ADV_FLAGS                                          = (byte) 0x01;
    public static byte BLE_ADV_INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS  = (byte) 0x02;
    public static byte BLE_ADV_COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS    = (byte) 0x03;
    public static byte BLE_ADV_INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS  = (byte) 0x04;
    public static byte BLE_ADV_COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS    = (byte) 0x05;
    public static byte BLE_ADV_INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS = (byte) 0x06;
    public static byte BLE_ADV_COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS   = (byte) 0x07;
    public static byte BLE_ADV_SHORTENED_LOCAL_NAME                           = (byte) 0x08;
    public static byte BLE_ADV_COMPLETE_LOCAL_NAME                            = (byte) 0x09;
    public static byte BLE_ADV_TX_POWER_LEVEL                                 = (byte) 0x0A;
    public static byte BLE_ADV_CLASS_OF_DEVICE                                = (byte) 0x0D;
    public static byte BLE_ADV_SIMPLE_PAIRING_HASH_C                          = (byte) 0x0E;
    public static byte BLE_ADV_SIMPLE_PAIRING_RANDOMIZER_R                    = (byte) 0x0F;
    public static byte BLE_ADV_SECURITY_MANAGER_TK_VALUE                      = (byte) 0x10;
    public static byte BLE_ADV_SECURITY_MANAGER_OUT_OF_BAND_FLAGS             = (byte) 0x11;
    public static byte BLE_ADV_SLAVE_CONNECTION_INTERVAL_RANGE                = (byte) 0x12;
    public static byte BLE_ADV_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS      = (byte) 0x14;
    public static byte BLE_ADV_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS     = (byte) 0x15;
    public static byte BLE_ADV_SERVICE_DATA                                   = (byte) 0x16;
    public static byte BLE_ADV_SERVICE_DATA_32_BIT_UUID                       = (byte) 0x20;
    public static byte BLE_ADV_SERVICE_DATA_128_BIT_UUID                      = (byte) 0x21;
    public static byte BLE_ADV_PUBLIC_TARGET_ADDRESS                          = (byte) 0x17;
    public static byte BLE_ADV_RANDOM_TARGET_ADDRESS                          = (byte) 0x18;
    public static byte BLE_ADV_APPEARANCE                                     = (byte) 0x19;
    public static byte BLE_ADV_ADVERTISING_INTERVAL                           = (byte) 0x1A;
    public static byte BLE_ADV_LE_BLUETOOTH_DEVICE_ADDRESS                    = (byte) 0x1B;
    public static byte BLE_ADV_LE_ROLE                                        = (byte) 0x1C;
    public static byte BLE_ADV_SIMPLE_PAIRING_HASH_C_256                      = (byte) 0x1D;
    public static byte BLE_ADV_SIMPLE_PAIRING_RANDOMIZER_R_256                = (byte) 0x1E;
    public static byte BLE_ADV_THREED_INFORMATION_DATA                        = (byte) 0x3D;
    public static byte BLE_ADV_MANUFACTURER_SPECIFIC_DATA                     = (byte) 0xFF;
    
    public static String advertisingTypeToString(byte type) {
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

    // GATT Namespace
    // https://developer.bluetooth.org/gatt/Pages/GattNamespaceDescriptors.aspx

    public static final byte GATT_NS_BT_SIG = (byte)0x01;

    // "The GATT characteristic descriptor defines a Description field that is related to the
    // Namespace. When the Namespace contains the value 0x01 (Bluetooth SIG), the Description field
    // contains one of the values from the table below.

    public static final short BLE_NS_BT_SIG_UNKNOWN	                         = (short) 0X0000;
    public static final short BLE_NS_BT_SIG_FIRST	                         = (short) 0X0001;
    public static final short BLE_NS_BT_SIG_SECOND	                         = (short) 0X0002;
    public static final short BLE_NS_BT_SIG_THIRD	                         = (short) 0X0003;
    public static final short BLE_NS_BT_SIG_FOURTH	                         = (short) 0X0004;
    public static final short BLE_NS_BT_SIG_FIFTH	                         = (short) 0X0005;
    public static final short BLE_NS_BT_SIG_SIXTH	                         = (short) 0X0006;
    public static final short BLE_NS_BT_SIG_SEVENTH	                         = (short) 0X0007;
    public static final short BLE_NS_BT_SIG_EIGHTH	                         = (short) 0X0008;
    public static final short BLE_NS_BT_SIG_NINETH	                         = (short) 0X0009;
    public static final short BLE_NS_BT_SIG_TENTH	                         = (short) 0X000A;
    public static final short BLE_NS_BT_SIG_ELEVENTH	                     = (short) 0X000B;
    public static final short BLE_NS_BT_SIG_TWELVETH	                     = (short) 0X000C;
    public static final short BLE_NS_BT_SIG_THIRTEENTH	                     = (short) 0X000D;
    public static final short BLE_NS_BT_SIG_FOURTEENTH	                     = (short) 0X000E;
    public static final short BLE_NS_BT_SIG_FIFTEENTH	                     = (short) 0X000F;
    public static final short BLE_NS_BT_SIG_SIXTEENTH	                     = (short) 0X0010;
    public static final short BLE_NS_BT_SIG_SEVENTEENTH	                     = (short) 0X0011;
    public static final short BLE_NS_BT_SIG_EIGHTEENTH	                     = (short) 0X0012;
    public static final short BLE_NS_BT_SIG_NINETEENTH	                     = (short) 0X0013;
    public static final short BLE_NS_BT_SIG_TWENTIETH	                     = (short) 0X0014;
    public static final short BLE_NS_BT_SIG_TWENTY_FIRST	                 = (short) 0X0015;
    public static final short BLE_NS_BT_SIG_TWENTY_SECOND	                 = (short) 0X0016;
    public static final short BLE_NS_BT_SIG_TWENTY_THIRD	                 = (short) 0X0017;
    public static final short BLE_NS_BT_SIG_TWENTY_FOURTH	                 = (short) 0X0018;
    public static final short BLE_NS_BT_SIG_TWENTY_FIFTH	                 = (short) 0X0019;
    public static final short BLE_NS_BT_SIG_TWENTY_SIXTH	                 = (short) 0X001A;
    public static final short BLE_NS_BT_SIG_TWENTY_SEVENTH	                 = (short) 0X001B;
    public static final short BLE_NS_BT_SIG_TWENTY_EIGHTH	                 = (short) 0X001C;
    public static final short BLE_NS_BT_SIG_TWENTY_NINETH	                 = (short) 0X001D;
    public static final short BLE_NS_BT_SIG_THIRTIETH	                     = (short) 0X001E;
    public static final short BLE_NS_BT_SIG_THIRTY_FIRST	                 = (short) 0X001F;
    public static final short BLE_NS_BT_SIG_THIRTY_SECOND	                 = (short) 0X0020;
    public static final short BLE_NS_BT_SIG_THIRTY_THIRD	                 = (short) 0X0021;
    public static final short BLE_NS_BT_SIG_THIRTY_FOURTH	                 = (short) 0X0022;
    public static final short BLE_NS_BT_SIG_THIRTY_FIFTH	                 = (short) 0X0023;
    public static final short BLE_NS_BT_SIG_THIRTY_SIXTH	                 = (short) 0X0024;
    public static final short BLE_NS_BT_SIG_THIRTY_SEVENTH	                 = (short) 0X0025;
    public static final short BLE_NS_BT_SIG_THIRTY_EIGHTH	                 = (short) 0X0026;
    public static final short BLE_NS_BT_SIG_THIRTY_NINETH	                 = (short) 0X0027;
    public static final short BLE_NS_BT_SIG_FORTIETH	                     = (short) 0X0028;
    public static final short BLE_NS_BT_SIG_FOURTY_FIRST	                 = (short) 0X0029;
    public static final short BLE_NS_BT_SIG_FOURTY_SECOND	                 = (short) 0X002A;
    public static final short BLE_NS_BT_SIG_FOURTY_THIRD	                 = (short) 0X002B;
    public static final short BLE_NS_BT_SIG_FOURTY_FOURTH	                 = (short) 0X002C;
    public static final short BLE_NS_BT_SIG_FOURTY_FIFTH	                 = (short) 0X002D;
    public static final short BLE_NS_BT_SIG_FOURTY_SIXTH	                 = (short) 0X002E;
    public static final short BLE_NS_BT_SIG_FOURTY_SEVENTH	                 = (short) 0X002F;
    public static final short BLE_NS_BT_SIG_FOURTY_EIGHTH	                 = (short) 0X0030;
    public static final short BLE_NS_BT_SIG_FOURTY_NINETH	                 = (short) 0X0031;
    public static final short BLE_NS_BT_SIG_FIFTIETH	                     = (short) 0X0032;
    public static final short BLE_NS_BT_SIG_FIFTY_FIRST	                     = (short) 0X0033;
    public static final short BLE_NS_BT_SIG_FIFTY_SECOND	                 = (short) 0X0034;
    public static final short BLE_NS_BT_SIG_FIFTY_THIRD	                     = (short) 0X0035;
    public static final short BLE_NS_BT_SIG_FIFTY_FOURTH	                 = (short) 0X0036;
    public static final short BLE_NS_BT_SIG_FIFTY_FIFTH	                     = (short) 0X0037;
    public static final short BLE_NS_BT_SIG_FIFTY_SIXTH	                     = (short) 0X0038;
    public static final short BLE_NS_BT_SIG_FIFTY_SEVENTH	                 = (short) 0X0039;
    public static final short BLE_NS_BT_SIG_FIFTY_EIGHTH	                 = (short) 0X003A;
    public static final short BLE_NS_BT_SIG_FIFTY_NINETH	                 = (short) 0X003B;
    public static final short BLE_NS_BT_SIG_SIXTIETH	                     = (short) 0X003C;
    public static final short BLE_NS_BT_SIG_SIXTY_FIRST	                     = (short) 0X003D;
    public static final short BLE_NS_BT_SIG_SIXTY_SECOND	                 = (short) 0X003E;
    public static final short BLE_NS_BT_SIG_SIXTY_THIRD	                     = (short) 0X003F;
    public static final short BLE_NS_BT_SIG_SIXTY_FOURTH	                 = (short) 0X0040;
    public static final short BLE_NS_BT_SIG_SIXTY_FIFTH	                     = (short) 0X0041;
    public static final short BLE_NS_BT_SIG_SIXTY_SIXTH	                     = (short) 0X0042;
    public static final short BLE_NS_BT_SIG_SIXTY_SEVENTH	                 = (short) 0X0043;
    public static final short BLE_NS_BT_SIG_SIXTY_EIGHTH	                 = (short) 0X0044;
    public static final short BLE_NS_BT_SIG_SIXTY_NINETH	                 = (short) 0X0045;
    public static final short BLE_NS_BT_SIG_SEVENTIETH	                     = (short) 0X0046;
    public static final short BLE_NS_BT_SIG_SEVENTY_FIRST	                 = (short) 0X0047;
    public static final short BLE_NS_BT_SIG_SEVENTY_SECOND	                 = (short) 0X0048;
    public static final short BLE_NS_BT_SIG_SEVENTY_THIRD	                 = (short) 0X0049;
    public static final short BLE_NS_BT_SIG_SEVENTY_FOURTH	                 = (short) 0X004A;
    public static final short BLE_NS_BT_SIG_SEVENTY_FIFTH	                 = (short) 0X004B;
    public static final short BLE_NS_BT_SIG_SEVENTY_SIXTH	                 = (short) 0X004C;
    public static final short BLE_NS_BT_SIG_SEVENTY_SEVENTH	                 = (short) 0X004D;
    public static final short BLE_NS_BT_SIG_SEVENTY_EIGHTH	                 = (short) 0X004E;
    public static final short BLE_NS_BT_SIG_SEVENTY_NINETH	                 = (short) 0X004F;
    public static final short BLE_NS_BT_SIG_EIGHTIETH	                     = (short) 0X0050;
    public static final short BLE_NS_BT_SIG_EIGHTY_FIRST	                 = (short) 0X0051;
    public static final short BLE_NS_BT_SIG_EIGHTY_SECOND	                 = (short) 0X0052;
    public static final short BLE_NS_BT_SIG_EIGHTY_THIRD	                 = (short) 0X0053;
    public static final short BLE_NS_BT_SIG_EIGHTY_FOURTH	                 = (short) 0X0054;
    public static final short BLE_NS_BT_SIG_EIGHTY_FIFTH	                 = (short) 0X0055;
    public static final short BLE_NS_BT_SIG_EIGHTY_SIXTH	                 = (short) 0X0056;
    public static final short BLE_NS_BT_SIG_EIGHTY_SEVENTH	                 = (short) 0X0057;
    public static final short BLE_NS_BT_SIG_EIGHTY_EIGHTH	                 = (short) 0X0058;
    public static final short BLE_NS_BT_SIG_EIGHTY_NINETH	                 = (short) 0X0059;
    public static final short BLE_NS_BT_SIG_NINETIETH	                     = (short) 0X005A;
    public static final short BLE_NS_BT_SIG_NINETY_FIRST	                 = (short) 0X005B;
    public static final short BLE_NS_BT_SIG_NINETY_SECOND	                 = (short) 0X005C;
    public static final short BLE_NS_BT_SIG_NINETY_THIRD	                 = (short) 0X005D;
    public static final short BLE_NS_BT_SIG_NINETY_FOURTH	                 = (short) 0X005E;
    public static final short BLE_NS_BT_SIG_NINETY_FIFTH	                 = (short) 0X005F;
    public static final short BLE_NS_BT_SIG_NINETY_SIXTH	                 = (short) 0X0060;
    public static final short BLE_NS_BT_SIG_NINETY_SEVENTH	                 = (short) 0X0061;
    public static final short BLE_NS_BT_SIG_NINETY_EIGHTH	                 = (short) 0X0062;
    public static final short BLE_NS_BT_SIG_NINETY_NINETH	                 = (short) 0X0063;
    public static final short BLE_NS_BT_SIG_ONE_HUNDREDTH	                 = (short) 0X0064;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIRST	         = (short) 0X0065;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SECOND	         = (short) 0X0066;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRD	         = (short) 0X0067;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTH	         = (short) 0X0068;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTH	         = (short) 0X0069;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTH	         = (short) 0X006A;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTH	         = (short) 0X006B;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTH	         = (short) 0X006C;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETH	         = (short) 0X006D;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TENTH	         = (short) 0X006E;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_ELEVENTH	     = (short) 0X006F;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWELVETH	     = (short) 0X0070;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTEENTH	     = (short) 0X0071;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTEENTH	     = (short) 0X0072;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTEENTH	     = (short) 0X0073;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTEENTH	     = (short) 0X0074;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTEENTH	     = (short) 0X0075;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTEENTH	     = (short) 0X0076;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETEENTH	     = (short) 0X0077;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_TWENTIETH	         = (short) 0X0078;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_FIRST	 = (short) 0X0079;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_SECOND	 = (short) 0X007A;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_THIRD	 = (short) 0X007B;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_FOURTH	 = (short) 0X007C;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_FIFTH	 = (short) 0X007D;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_SIXTH	 = (short) 0X007E;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_SEVENTH	 = (short) 0X007F;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_EIGHTH	 = (short) 0X0080;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_TWENTY_NINETH	 = (short) 0X0081;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_THIRTIETH	         = (short) 0X0082;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_FIRST	 = (short) 0X0083;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_SECOND	 = (short) 0X0084;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_THIRD	 = (short) 0X0085;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_FOURTH	 = (short) 0X0086;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_FIFTH	 = (short) 0X0087;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_SIXTH	 = (short) 0X0088;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_SEVENTH	 = (short) 0X0089;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_EIGHTH	 = (short) 0X008A;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_THIRTY_NINETH	 = (short) 0X008B;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_FORTIETH	         = (short) 0X008C;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_FIRST	 = (short) 0X008D;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_SECOND	 = (short) 0X008E;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_THIRD	 = (short) 0X008F;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_FOURTH	 = (short) 0X0090;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_FIFTH	 = (short) 0X0091;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_SIXTH	 = (short) 0X0092;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_SEVENTH	 = (short) 0X0093;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_EIGHTH	 = (short) 0X0094;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FOURTY_NINETH	 = (short) 0X0095;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_FIFTIETH	         = (short) 0X0096;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_FIRST	     = (short) 0X0097;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_SECOND	 = (short) 0X0098;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_THIRD	     = (short) 0X0099;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_FOURTH	 = (short) 0X009A;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_FIFTH	     = (short) 0X009B;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_SIXTH	     = (short) 0X009C;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_SEVENTH	 = (short) 0X009D;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_EIGHTH	 = (short) 0X009E;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_FIFTY_NINETH	 = (short) 0X009F;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_SIXTIETH	         = (short) 0X00A0;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_FIRST	     = (short) 0X00A1;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_SECOND	 = (short) 0X00A2;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_THIRD	     = (short) 0X00A3;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_FOURTH	 = (short) 0X00A4;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_FIFTH	     = (short) 0X00A5;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_SIXTH	     = (short) 0X00A6;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_SEVENTH	 = (short) 0X00A7;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_EIGHTH	 = (short) 0X00A8;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SIXTY_NINETH	 = (short) 0X00A9;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_SEVENTIETH	         = (short) 0X00AA;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_FIRST	 = (short) 0X00AB;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_SECOND	 = (short) 0X00AC;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_THIRD	 = (short) 0X00AD;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_FOURTH	 = (short) 0X00AE;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_FIFTH	 = (short) 0X00AF;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_SIXTH	 = (short) 0X00B0;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_SEVENTH	 = (short) 0X00B1;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_EIGHTH	 = (short) 0X00B2;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_SEVENTY_NINETH	 = (short) 0X00B3;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_EIGHTIETH	         = (short) 0X00B4;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_FIRST	 = (short) 0X00B5;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_SECOND	 = (short) 0X00B6;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_THIRD	 = (short) 0X00B7;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_FOURTH	 = (short) 0X00B8;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_FIFTH	 = (short) 0X00B9;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_SIXTH	 = (short) 0X00BA;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_SEVENTH	 = (short) 0X00BB;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_EIGHTH	 = (short) 0X00BC;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_EIGHTY_NINETH	 = (short) 0X00BD;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_NINETIETH	         = (short) 0X00BE;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_FIRST	 = (short) 0X00BF;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_SECOND	 = (short) 0X00C0;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_THIRD	 = (short) 0X00C1;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_FOURTH	 = (short) 0X00C2;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_FIFTH	 = (short) 0X00C3;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_SIXTH	 = (short) 0X00C4;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_SEVENTH	 = (short) 0X00C5;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_EIGHTH	 = (short) 0X00C6;
    public static final short BLE_NS_BT_SIG_ONE_HUNDRED_AND_NINETY_NINETH	 = (short) 0X00C7;
    public static final short BLE_NS_BT_SIG_TWO_HUNDREDTH	                 = (short) 0X00C8;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIRST	         = (short) 0X00C9;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_SECOND	         = (short) 0X00CA;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRD	         = (short) 0X00CB;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTH	         = (short) 0X00CC;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTH	         = (short) 0X00CD;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_SIXTH	         = (short) 0X00CE;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_SEVENTH	         = (short) 0X00CF;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_EIGHTH	         = (short) 0X00D0;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_NINETH	         = (short) 0X00D1;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TENTH	         = (short) 0X00D2;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_ELEVENTH	     = (short) 0X00D3;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWELVETH	     = (short) 0X00D4;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTEENTH	     = (short) 0X00D5;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTEENTH	     = (short) 0X00D6;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTEENTH	     = (short) 0X00D7;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_SIXTEENTH	     = (short) 0X00D8;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_SEVENTEENTH	     = (short) 0X00D9;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_EIGHTEENTH	     = (short) 0X00DA;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_NINETEENTH	     = (short) 0X00DB;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_TWENTIETH	         = (short) 0X00DC;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_FIRST	 = (short) 0X00DD;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_SECOND	 = (short) 0X00DE;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_THIRD	 = (short) 0X00DF;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_FOURTH	 = (short) 0X00E0;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_FIFTH	 = (short) 0X00E1;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_SIXTH	 = (short) 0X00E2;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_SEVENTH	 = (short) 0X00E3;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_EIGHTH	 = (short) 0X00E4;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_TWENTY_NINETH	 = (short) 0X00E5;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_THIRTIETH	         = (short) 0X00E6;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_FIRST	 = (short) 0X00E7;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_SECOND	 = (short) 0X00E8;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_THIRD	 = (short) 0X00E9;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_FOURTH	 = (short) 0X00EA;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_FIFTH	 = (short) 0X00EB;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_SIXTH	 = (short) 0X00EC;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_SEVENTH	 = (short) 0X00ED;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_EIGHTH	 = (short) 0X00EE;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_THIRTY_NINETH	 = (short) 0X00EF;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_FORTIETH	         = (short) 0X00F0;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_FIRST	 = (short) 0X00F1;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_SECOND	 = (short) 0X00F2;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_THIRD	 = (short) 0X00F3;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_FOURTH	 = (short) 0X00F4;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_FIFTH	 = (short) 0X00F5;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_SIXTH	 = (short) 0X00F6;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_SEVENTH	 = (short) 0X00F7;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_EIGHTH	 = (short) 0X00F8;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FOURTY_NINETH	 = (short) 0X00F9;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_FIFTIETH	         = (short) 0X00FA;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTY_FIRST	     = (short) 0X00FB;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTY_SECOND	 = (short) 0X00FC;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTY_THIRD	     = (short) 0X00FD;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTY_FOURTH	 = (short) 0X00FE;
    public static final short BLE_NS_BT_SIG_TWO_HUNDRED_AND_FIFTY_FIFTH  	 = (short) 0X00FF;
    public static final short BLE_NS_BT_SIG_FRONT	                         = (short) 0X0100;
    public static final short BLE_NS_BT_SIG_BACK	                         = (short) 0X0101;
    public static final short BLE_NS_BT_SIG_TOP	                             = (short) 0X0102;
    public static final short BLE_NS_BT_SIG_BOTTOM	                         = (short) 0X0103;
    public static final short BLE_NS_BT_SIG_UPPER	                         = (short) 0X0104;
    public static final short BLE_NS_BT_SIG_LOWER	                         = (short) 0X0105;
    public static final short BLE_NS_BT_SIG_MAIN	                         = (short) 0X0106;
    public static final short BLE_NS_BT_SIG_BACKUP	                         = (short) 0X0107;
    public static final short BLE_NS_BT_SIG_AUXILIARY	                     = (short) 0X0108;
    public static final short BLE_NS_BT_SIG_SUPPLEMENTARY	                 = (short) 0X0109;
    public static final short BLE_NS_BT_SIG_FLASH	                         = (short) 0X010A;
    public static final short BLE_NS_BT_SIG_INSIDE	                         = (short) 0X010B;
    public static final short BLE_NS_BT_SIG_OUTSIDE	                         = (short) 0X010C;
    public static final short BLE_NS_BT_SIG_LEFT	                         = (short) 0X010D;
    public static final short BLE_NS_BT_SIG_RIGHT	                         = (short) 0X010E;
    public static final short BLE_NS_BT_SIG_INTERNAL	                     = (short) 0X010F;
    public static final short BLE_NS_BT_SIG_EXTERNAL	                     = (short) 0X0110;

}
