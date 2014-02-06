package com.samiamharris.samnotesapp.com.samiamharris.samnotesapp.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by samharris on 1/14/14.
 */
public class NoteItem {

    private String key;
    private String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //placing name of class before method (return type)means we will be returning an instance of the class
    public static NoteItem getNew() {

        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem();
        note.setKey(key);
        note.setText("");
        return note;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
