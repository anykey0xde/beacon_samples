package pak.ble.sample;

/**
 * Created by a2800276 on 03/04/14.
 */
public class BLEUtils {
    static String toHex(byte [] bytes) {
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
}
