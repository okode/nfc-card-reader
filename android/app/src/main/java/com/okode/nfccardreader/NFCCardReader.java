package com.okode.nfccardreader;

import android.nfc.NfcAdapter;
import android.nfc.Tag;

public class NFCCardReader implements NfcAdapter.ReaderCallback {

    private MainActivity mainActivity;

    public NFCCardReader(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onTagDiscovered(Tag tag) {
        String tagId = bytesToHexString(tag.getId());
        mainActivity.displayTagId(tagId);
    }

    private String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("0x");
        if (src == null || src.length <= 0) {
            return null;
        }

        char[] buffer = new char[2];
        for (int i = 0; i < src.length; i++) {
            buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);
            buffer[1] = Character.forDigit(src[i] & 0x0F, 16);
            System.out.println(buffer);
            stringBuilder.append(buffer);
        }

        return stringBuilder.toString();
    }
}
