package com.samiamharris.samnotesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.samiamharris.samnotesapp.com.samiamharris.samnotesapp.data.NoteItem;

/**
 * Created by samharris on 1/15/14.
 */
public class NoteEditorActivity extends Activity {

    private NoteItem note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_layout);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        note = new NoteItem();
        note.setKey(intent.getStringExtra("key"));
        note.setText(intent.getStringExtra("text"));

        EditText et = (EditText) findViewById(R.id.note_text);
        et.setText(note.getText());
        et.setSelection(note.getText().length());

    }

    private void saveAndFinish() {
        EditText et = (EditText) findViewById(R.id.note_text);
        String noteText = et.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("key", note.getKey());
        intent.putExtra("text", noteText);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            saveAndFinish();
        }
        return false;

    }

    @Override
    public void onBackPressed() {
        saveAndFinish();
    }
}
