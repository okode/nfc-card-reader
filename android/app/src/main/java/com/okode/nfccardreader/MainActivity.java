package com.okode.nfccardreader;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableReaderMode();
    }

    private void enableReaderMode() {
        NfcAdapter nfc = NfcAdapter.getDefaultAdapter(this);
        if (nfc != null) {
            nfc.enableReaderMode(this, new NFCCardReader(this), NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK, null);
        }
    }

    public void displayTagId(final String tagId) {
        final TextView txtTagId = (TextView) findViewById(R.id.txtTagId);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtTagId.setText(tagId);
            }
        });
    }
}
