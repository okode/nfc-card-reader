package com.okode.nfccardemulator;


import android.util.Log;

public abstract class Utils {

    private static final String LOGCAT_TAG = "NFC_CARD_EMULATOR";
    private static final String HEX_DIGITS = "0123456789ABCDEF";

    public static String toHex(byte[] data) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i != data.length; i++) {
            int v = data[i] & 0xff;

            buf.append(HEX_DIGITS.charAt(v >> 4));
            buf.append(HEX_DIGITS.charAt(v & 0xf));

            buf.append(" ");
        }

        return buf.toString();
    }

    public static void log(String message) {
        Log.i(LOGCAT_TAG, message);
    }

    public static void logApdu(byte[] apdu) {
        Log.i(LOGCAT_TAG, String.format("APDU: %s", toHex(apdu)));
    }

}
