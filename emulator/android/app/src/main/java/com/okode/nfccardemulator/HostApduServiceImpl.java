package com.okode.nfccardemulator;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

public class HostApduServiceImpl extends HostApduService {

    private static final byte[] RESPONSE_9000 = { (byte)0x90, (byte)0x00 };

    private enum ApduCommandType { AID, CUSTOM };

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        Utils.logApdu(commandApdu);

        byte[] result = new byte[0];
        switch (apduCommandType(commandApdu)) {
            case AID:
                Utils.log("-- AID received");
                result = RESPONSE_9000;
                break;
            case CUSTOM:
            default:
                Utils.log("-- Custom command received");
                result = RESPONSE_9000;
                break;
        }

        return result;
    }

    @Override
    public void onDeactivated(int reason) {
        Utils.log(String.format("NFC deactivated. Reason: %d", reason));
    }

    private ApduCommandType apduCommandType(byte[] apdu) {
        if (apdu.length >= 2 && apdu[0] == (byte)0 && apdu[1] == (byte)0xa4) return ApduCommandType.AID;
        return ApduCommandType.CUSTOM;
    }

}
