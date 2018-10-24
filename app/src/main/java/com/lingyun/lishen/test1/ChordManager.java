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

    private HashMap<Chord, SoundManager.Tone[]> mEnumMap = new HashMap<Chord, SoundManager.Tone[]>();
    private HashMap<CharSequence, SoundManager.Tone[]> mStrMap = new HashMap<CharSequence, SoundManager.Tone[]>();
    private SoundManager.Tone[] mCurTones;

    public ChordManager(){
        SoundManager.Tone[] tone;

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4};
        mEnumMap.put(Chord.CHORD_C, tone);
        mStrMap.put("C", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_G4_b};
        mEnumMap.put(Chord.CHORD_D, tone);
        mStrMap.put("D", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4_s,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4};
        mEnumMap.put(Chord.CHORD_E, tone);
        mStrMap.put("E", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_C5,
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C5,
                SoundManager.Tone.TONE_F4};
        mEnumMap.put(Chord.CHORD_F, tone);
        mStrMap.put("F", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G4};
        mEnumMap.put(Chord.CHORD_G, tone);
        mStrMap.put("G", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_E5,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C4_s,
                SoundManager.Tone.TONE_E4};
        mEnumMap.put(Chord.CHORD_A, tone);
        mStrMap.put("A", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G5_b,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E5_b,
                SoundManager.Tone.TONE_MUTE};
        mEnumMap.put(Chord.CHORD_B, tone);
        mStrMap.put("B", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4_b,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_MUTE};
        mEnumMap.put(Chord.CHORD_Cm, tone);
        mStrMap.put("Cm", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_D4,
                SoundManager.Tone.TONE_F4};
        mEnumMap.put(Chord.CHORD_Dm, tone);
        mStrMap.put("Dm", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_E4};
        mEnumMap.put(Chord.CHORD_Em, tone);
        mStrMap.put("Em", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_F4,
                SoundManager.Tone.TONE_G4_s,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_F4};
        mEnumMap.put(Chord.CHORD_Fm, tone);
        mStrMap.put("Fm", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_B4_b,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G4};
        mEnumMap.put(Chord.CHORD_Gm, tone);
        mStrMap.put("Gm", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_E5,
                SoundManager.Tone.TONE_A4,
                SoundManager.Tone.TONE_C4,
                SoundManager.Tone.TONE_E4};
        mEnumMap.put(Chord.CHORD_Am, tone);
        mStrMap.put("Am", tone);

        tone = new SoundManager.Tone[]{
                SoundManager.Tone.TONE_MUTE,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_G5_b,
                SoundManager.Tone.TONE_B4,
                SoundManager.Tone.TONE_D5,
                SoundManager.Tone.TONE_G5_b};
        mEnumMap.put(Chord.CHORD_Bm, tone);
        mStrMap.put("Bm", tone);
    }

    public void setChord(CharSequence name) {
        mCurTones = mStrMap.get(name);
    }

    public void setChord(Chord chord){
        mCurTones = mEnumMap.get(chord);
    }

    public SoundManager.Tone getTone(Integer strIdx){
        if (strIdx < mCurTones.length){
            return mCurTones[strIdx];
        } else {
            return SoundManager.Tone.TONE_MUTE;
        }
    }
}
