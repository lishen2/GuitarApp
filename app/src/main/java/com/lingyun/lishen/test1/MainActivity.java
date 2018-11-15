package com.lingyun.lishen.test1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.lingyun.test1.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, GuitarActivity.class);
        startActivity(intent);
    }

    public void lunchListTest(View view) {
        Intent intent = new Intent(this, ListTestActivity.class);
        startActivity(intent);
    }

    public void playNote(View view) {
        String message;
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MIDI)) {
            message = "Midi support";
        } else {
            message = "Midi not support";
        }

        MidiManager m = (MidiManager)this.getSystemService(Context.MIDI_SERVICE);
        MidiDeviceInfo[] infos = m.getDevices();
        message += ("Dev num:" + infos.length);

        Intent intent = new Intent(this, GuitarActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
