package com.lingyun.lishen.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GuitarActivity extends AppCompatActivity {

    SoundManager mSoundM;
    ChordManager mChordM;

    private int mLastX;
    private static int SPLIT0 = 225 + 90 * 1;
    private static int SPLIT1 = 225 + 90 * 2;
    private static int SPLIT2 = 225 + 90 * 3;
    private static int SPLIT3 = 225 + 90 * 4;
    private static int SPLIT4 = 225 + 90 * 5;
    private static int SPLIT5 = 225 + 90 * 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //new sound manager
        mSoundM = new SoundManager(this);
        mSoundM.loadInstrument(SoundManager.Instrument.INS_ACOUSTIC_GUITAR);

        //new chord manager
        mChordM = new ChordManager();
        mChordM.setChord(ChordManager.Chord.CHORD_C);

        //connect touch event
        View touchView = findViewById(R.id.view);
        touchView.setOnTouchListener(mCorkyListener);
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
            default:
                return super.onKeyUp(keyCode, event);
        }

        return true;
    }

    public void setChordC(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_C);
    }

    public void setChordD(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_D);
    }

    public void setChordE(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_E);
    }

    public void setChordF(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_F);
    }

    public void setChordG(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_G);
    }

    public void setChordA(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_A);
    }

    public void setChordB(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_B);
    }

    public void setChordCm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Cm);
    }

    public void setChordDm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Dm);
    }

    public void setChordEm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Em);
    }

    public void setChordFm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Fm);
    }

    public void setChordGm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Gm);
    }

    public void setChordAm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Am);
    }

    public void setChordBm(View view) {
        mChordM.setChord(ChordManager.Chord.CHORD_Bm);
    }

    // Create an anonymous implementation of OnClickListener
    private View.OnTouchListener mCorkyListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent e) {
            SoundManager.Tone tone;
            int x;
            x = (int)e.getX(0);
            if (MotionEvent.ACTION_MOVE == e.getActionMasked()){
                if ((mLastX > SPLIT0 && x < SPLIT0) || (mLastX < SPLIT0 && x > SPLIT0)){
                    tone = mChordM.getTone(0);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
                if ((mLastX > SPLIT1 && x < SPLIT1) || (mLastX < SPLIT1 && x > SPLIT1)){
                    tone = mChordM.getTone(1);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
                if ((mLastX > SPLIT2 && x < SPLIT2) || (mLastX < SPLIT2 && x > SPLIT2)){
                    tone = mChordM.getTone(2);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
                if ((mLastX > SPLIT3 && x < SPLIT3) || (mLastX < SPLIT3 && x > SPLIT3)){
                    tone = mChordM.getTone(3);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
                if ((mLastX > SPLIT4 && x < SPLIT4) || (mLastX < SPLIT4 && x > SPLIT4)){
                    tone = mChordM.getTone(4);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
                if ((mLastX > SPLIT5 && x < SPLIT5) || (mLastX < SPLIT5 && x > SPLIT5)){
                    tone = mChordM.getTone(5);
                } else {
                    tone = SoundManager.Tone.TONE_MUTE;
                }
                mSoundM.playTone(tone);
            }
            mLastX = x;
            return true;
        }
    };

}
