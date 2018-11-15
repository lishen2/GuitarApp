package com.lingyun.lishen.test1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class GuitarActivity extends FragmentActivity
        implements ChordSelectDialogFragment.NoticeDialogListener{

    private SoundManager mSoundM;
    private ChordManager mChordM;

    private static int SPLIT0 = 400 + 70 * 1;
    private static int SPLIT1 = 400 + 70 * 2;
    private static int SPLIT2 = 400 + 70 * 3;
    private static int SPLIT3 = 400 + 70 * 4;
    private static int SPLIT4 = 400 + 70 * 5;
    private static int SPLIT5 = 400 + 70 * 6;
    private static String DEFAULT_CHORD = "C";

    private int mLastY;
    private Switch mEditSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);

        //new sound manager
        mSoundM = new SoundManager(this);
        mSoundM.loadInstrument(SoundManager.Instrument.INS_ACOUSTIC_GUITAR);

        //new chord manager
        mChordM = new ChordManager();
        mChordM.setChord(ChordManager.Chord.CHORD_C);

        //connect touch event
        View touchView = findViewById(R.id.view);
        touchView.setOnTouchListener(mCorkyListener);

        //button configure
        initButton();

        mEditSwitch = findViewById(R.id.editSwitch);;
    }

    private void configOneBtn(Button btn, String text) {
        btn.setText(text);
        btn.setOnTouchListener(mChordTouchListener);
        btn.setOnLongClickListener(mChordLongClickListener);
    }

    private void initButton() {
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        Button btn;

        btn = findViewById(R.id.btnChord1);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord2);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord3);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord4);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord5);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord6);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord7);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord8);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord9);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord10);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord11);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord12);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord13);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord14);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));

        btn = findViewById(R.id.btnChord15);
        configOneBtn(btn, pref.getString(getResources().getResourceEntryName(btn.getId()), DEFAULT_CHORD));
    }

    private void saveConfig(String key, String value){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_C:
                mChordM.setChord(ChordManager.Chord.CHORD_C);
                break;
            case KeyEvent.KEYCODE_D:
                mChordM.setChord(ChordManager.Chord.CHORD_D);
                break;
            case KeyEvent.KEYCODE_E:
                mChordM.setChord(ChordManager.Chord.CHORD_E);
                break;
            case KeyEvent.KEYCODE_F:
                mChordM.setChord(ChordManager.Chord.CHORD_F);
                break;
            case KeyEvent.KEYCODE_G:
                mChordM.setChord(ChordManager.Chord.CHORD_G);
                break;
            case KeyEvent.KEYCODE_Q:
                mChordM.setChord(ChordManager.Chord.CHORD_Am);
                break;
            case KeyEvent.KEYCODE_W:
                mChordM.setChord(ChordManager.Chord.CHORD_Em);
                break;
            case KeyEvent.KEYCODE_U:
                mSoundM.playTone(mChordM.getTone(0));
                break;
            case KeyEvent.KEYCODE_I:
                mSoundM.playTone(mChordM.getTone(1));
                break;
            case KeyEvent.KEYCODE_O:
                mSoundM.playTone(mChordM.getTone(2));
                break;
            case KeyEvent.KEYCODE_P:
                mSoundM.playTone(mChordM.getTone(3));
                break;
            default:
        }

        return super.onKeyDown(keyCode, event);
    }

    // Create an anonymous implementation of OnClickListener
    private View.OnTouchListener mCorkyListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent e) {

            SoundManager.Tone tone;
            int y;
            y = (int)e.getY(0);

            if (MotionEvent.ACTION_MOVE == e.getActionMasked()){
                if ((mLastY > SPLIT0 && y <= SPLIT0) || (mLastY < SPLIT0 && y >= SPLIT0)){
                    tone = mChordM.getTone(0);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "0");
                }
                if ((mLastY > SPLIT1 && y <= SPLIT1) || (mLastY < SPLIT1 && y >= SPLIT1)){
                    tone = mChordM.getTone(1);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "1");
                }
                if ((mLastY > SPLIT2 && y <= SPLIT2) || (mLastY < SPLIT2 && y >= SPLIT2)){
                    tone = mChordM.getTone(2);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "2");
                }
                if ((mLastY > SPLIT3 && y <= SPLIT3) || (mLastY < SPLIT3 && y >= SPLIT3)){
                    tone = mChordM.getTone(3);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "3");
                }
                if ((mLastY > SPLIT4 && y <= SPLIT4) || (mLastY < SPLIT4 && y >= SPLIT4)){
                    tone = mChordM.getTone(4);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "4");
                }
                if ((mLastY > SPLIT5 && y <= SPLIT5) || (mLastY < SPLIT5 && y >= SPLIT5)){
                    tone = mChordM.getTone(5);
                    mSoundM.playTone(tone);
                    //Log.v("eGuitar", "5");
                }
            }
            mLastY = y;

            return true;
        }
    };

    private View.OnTouchListener mChordTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent e) {
            if (MotionEvent.ACTION_DOWN == e.getActionMasked()) {
                Button btn = (Button)v;
                mChordM.setChord(btn.getText());
            }
            return false;
        }
    };

    private Button mCurrentButton;

    private View.OnLongClickListener mChordLongClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
            if (true == mEditSwitch.isChecked()){
                /* set current editing button */
                mCurrentButton = (Button)v;
                /* show dialog */
                DialogFragment newFragment = new ChordSelectDialogFragment();
                newFragment.show(getSupportFragmentManager(), "SelectChords");
            }
            Log.v("eGuitar", "Button long click");
            return true;
        }
    };

    public void onDialogItemClick(DialogFragment dialog, CharSequence name) {
        Log.v("eGuitar", String.format("Dialog selected item %s", name));
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(getResources().getResourceEntryName(mCurrentButton.getId()), name.toString());
        editor.commit();

        mCurrentButton.setText(name);

        return;
    }
}
