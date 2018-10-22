package com.lingyun.lishen.test1;

import java.util.HashMap;

public class ChordManager {
    public enum Chord
    {
        CHORD_C,
        CHORD_D,
        CHORD_E,
        CHORD_F,
        CHORD_G,
        CHORD_A,
        CHORD_B,
        CHORD_Cm,
        CHORD_Dm,
        CHORD_Em,
        CHORD_Fm,
        CHORD_Gm,
        CHORD_Am,
        CHORD_Bm,
    }

    HashMap<Chord, SoundManager.Tone[]> mChords = new HashMap<Chord, SoundManager.Tone[]>();
    SoundManager.Tone[] mCurTones;

    public ChordManager(){

        mChords.put(Chord.CHORD_C, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4});

        mChords.put(Chord.CHORD_D, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_G4_b});

        mChords.put(Chord.CHORD_E, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4_s,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4});

        mChords.put(Chord.CHORD_F, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_C5,
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C5,
                SoundManager.Tone.TONE_F4});

        mChords.put(Chord.CHORD_G, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G4});

        mChords.put(Chord.CHORD_A, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_E5,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C4_s,
                SoundManager.Tone.TONE_E4});

        mChords.put(Chord.CHORD_B, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G5_b,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E5_b,
                SoundManager.Tone.TONE_MUTE});

        mChords.put(Chord.CHORD_Cm, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4_b,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_MUTE});

        mChords.put(Chord.CHORD_Dm, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_F4});

        mChords.put(Chord.CHORD_Em, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4});

        mChords.put(Chord.CHORD_Fm, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_G4_s,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_F4});

        mChords.put(Chord.CHORD_Gm, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4_b,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4});

        mChords.put(Chord.CHORD_Am, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_E5,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4});

        mChords.put(Chord.CHORD_Bm, new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G5_b,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G5_b});
    }

    public void setChord(Chord chord){
        mCurTones = mChords.get(chord);
    }

    public SoundManager.Tone getTone(Integer strIdx){
        if (strIdx < mCurTones.length){
            return mCurTones[strIdx];
        } else {
            return SoundManager.Tone.TONE_MUTE;
        }
    }
}
