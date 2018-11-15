package com.lingyun.lishen.test1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);

        ListView keynoteListView = (ListView) findViewById(R.id.listKeynote);
        ListView chordListView = (ListView) findViewById(R.id.listChord);

        keynoteListView.setAdapter(
                new ArrayAdapter<String>(
                        this, android.R.layout.simple_list_item_1, getKeyNotes()));
        chordListView.setAdapter(
                new ArrayAdapter<String>(
                        this, android.R.layout.simple_list_item_1, getChords()));
    }

    private List<String> getKeyNotes()
    {
        ArrayList<String> keynotes = new ArrayList<String>();

        keynotes.add("C");
        keynotes.add("D");
        keynotes.add("E");
        keynotes.add("F");
        keynotes.add("G");
        keynotes.add("A");
        keynotes.add("B");

        return keynotes;
    }

    private List<String> getChords()
    {
        ArrayList<String> chords = new ArrayList<String>();

        chords.add("Major");
        chords.add("Miner");

        return chords;
    }
}
