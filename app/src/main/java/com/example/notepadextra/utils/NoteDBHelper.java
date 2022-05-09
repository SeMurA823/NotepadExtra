package com.example.notepadextra.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDBHelper extends SQLiteOpenHelper {

    private static NoteDBHelper instance;

    public static final int DB_VERSION = 6;
    public static final String DB_NAME = "Notepad.db";

    private NoteDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Queries.SQL_CREATE_TAG_TABLE);
        db.execSQL(Queries.SQL_CREATE_NOTE_TABLE);
        db.execSQL(Queries.SQL_CREATE_TAG_NOTE_RELATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(Queries.SQL_DROP_TAG_NOTE_RELATION_TABLE);
        db.execSQL(Queries.SQL_DROP_NOTE_TABLE);
        db.execSQL(Queries.SQL_DROP_TAG_TABLE);
        onCreate(db);
    }

    public static NoteDBHelper getInstance(Context context) {
        if (instance == null)
            instance = new NoteDBHelper(context);
        return instance;
    }
}
