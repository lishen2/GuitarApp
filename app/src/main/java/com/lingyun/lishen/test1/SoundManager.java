package com.lingyun.lishen.test1;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class SoundManager {

    public enum Tone{
        TONE_C4,
        TONE_C4_s,
        TONE_D4,
        TONE_E4,
        TONE_E4_b,
        TONE_F4,
        TONE_G4_b,
        TONE_G4,
        TONE_G4_s,
        TONE_A4,
        TONE_B4_b,
        TONE_B4,
        TONE_C5,
        TONE_C5_s,
        TONE_D5,
        TONE_E5,
        TONE_E5_b,
        TONE_F5,
        TONE_G5_b,
        TONE_G5,
        TONE_MUTE,
    };

    public enum Instrument{
        INS_ACOUSTIC_GUITAR,
    };

    private static final int STRING_NUMBER = 6;

    private AppCompatActivity mActivity;
    private SoundPool mSoundPool;
    HashMap<Tone, Integer> mMmusicId = new HashMap<Tone, Integer>();

    public SoundManager(AppCompatActivity activity){
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(STRING_NUMBER);
        AudioAttributes attr = new AudioAttributes.Builder().setLegacyStreamType(AudioManager.STREAM_SYSTEM).build();
        builder.setAudioAttributes(attr);
        mSoundPool = builder.build();
        mActivity = activity;
    }

    public void loadInstrument(Instrument inst){
        mMmusicId.put(Tone.TONE_C4,   mSoundPool.load(mActivity, R.raw.c4, 1));
        mMmusicId.put(Tone.TONE_C4_s, mSoundPool.load(mActivity, R.raw.c4_s, 1));
        mMmusicId.put(Tone.TONE_D4,   mSoundPool.load(mActivity, R.raw.d4, 1));
        mMmusicId.put(Tone.TONE_E4,   mSoundPool.load(mActivity, R.raw.e4, 1));
        mMmusicId.put(Tone.TONE_E4_b, mSoundPool.load(mActivity, R.raw.e4_b, 1));
        mMmusicId.put(Tone.TONE_F4,   mSoundPool.load(mActivity, R.raw.f4, 1));
        mMmusicId.put(Tone.TONE_G4_b, mSoundPool.load(mActivity, R.raw.g4_b, 1));
        mMmusicId.put(Tone.TONE_G4,   mSoundPool.load(mActivity, R.raw.g4, 1));
        mMmusicId.put(Tone.TONE_G4_s, mSoundPool.load(mActivity, R.raw.g4_s, 1));
        mMmusicId.put(Tone.TONE_A4,   mSoundPool.load(mActivity, R.raw.a4, 1));
        mMmusicId.put(Tone.TONE_B4_b, mSoundPool.load(mActivity, R.raw.b4_b, 1));
        mMmusicId.put(Tone.TONE_B4,   mSoundPool.load(mActivity, R.raw.b4, 1));
        mMmusicId.put(Tone.TONE_C5,   mSoundPool.load(mActivity, R.raw.c5, 1));
        mMmusicId.put(Tone.TONE_C5_s, mSoundPool.load(mActivity, R.raw.c5_s, 1));
        mMmusicId.put(Tone.TONE_D5,   mSoundPool.load(mActivity, R.raw.d5, 1));
        mMmusicId.put(Tone.TONE_E5,   mSoundPool.load(mActivity, R.raw.e5, 1));
        mMmusicId.put(Tone.TONE_E5_b, mSoundPool.load(mActivity, R.raw.e5_b, 1));
        mMmusicId.put(Tone.TONE_F5,   mSoundPool.load(mActivity, R.raw.f5, 1));
        mMmusicId.put(Tone.TONE_G5_b, mSoundPool.load(mActivity, R.raw.g5_b, 1));
        mMmusicId.put(Tone.TONE_G5,   mSoundPool.load(mActivity, R.raw.g5, 1));
    }

    public void playTone(Tone tone)
    {
        if (Tone.TONE_MUTE == tone){
            return;
        }
        mSoundPool.play(mMmusicId.get(tone), 1, 1, 0, 0, 1);
    }

}
