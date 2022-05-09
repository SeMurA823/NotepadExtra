package com.example.notepadextra.di;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.notepadextra.dao.NoteDAO;
import com.example.notepadextra.dao.NoteTagDAO;
import com.example.notepadextra.dao.TagDAO;
import com.example.notepadextra.utils.NoteDBHelper;

public class ServiceLocator {
    private static ServiceLocator instance;

    private Context context;

    private ServiceLocator() {

    }

    public static ServiceLocator init(Context context) {
        instance = new ServiceLocator();
        instance.context = context;
        return instance;
    }

    public static ServiceLocator getInstance() {
        if (instance == null)
            throw new IllegalStateException("Service locator not initialized");
        return instance;
    }

    public SQLiteOpenHelper dbHelper() {
        return NoteDBHelper.getInstance(context);
    }

    public TagDAO tagDAO() {
        return TagDAO.getInstance(dbHelper().getWritableDatabase());
    }

    public NoteDAO noteDAO() {
        return NoteDAO.getInstance(dbHelper().getWritableDatabase());
    }

    public NoteTagDAO noteTagDAO() {
        return NoteTagDAO.getInstance(dbHelper().getWritableDatabase());
    }


}
