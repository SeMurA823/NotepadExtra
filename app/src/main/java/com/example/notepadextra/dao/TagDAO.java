package com.example.notepadextra.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notepadextra.dao.mappers.TagMapper;
import com.example.notepadextra.entities.TagEntity;
import com.example.notepadextra.utils.Queries;
import com.example.notepadextra.utils.Tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TagDAO {

    private static TagDAO instance;

    private final SQLiteDatabase db;


    public TagDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public static TagDAO getInstance(SQLiteDatabase db) {
        if (instance == null)
            instance = new TagDAO(db);
        return instance;
    }

    public TagEntity update(TagEntity tagEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", tagEntity.getName());
        int update = db.update(Tables.TAGS.name(),
                contentValues,
                "id = ?",
                new String[]{tagEntity.getUuid().toString()});
        return tagEntity;
    }

    public TagEntity insert(TagEntity tagEntity) {
        long insert = db.insert(
                Tables.TAGS.name(),
                null,
                TagMapper.getInstance().toCV(tagEntity)
        );
        return tagEntity;
    }

    public int delete(UUID uuid) {
        return db.delete(Tables.TAGS.name(),
                "id = ?",
                new String[]{uuid.toString()});
    }

    public TagEntity delete(TagEntity tagEntity) {
        delete(tagEntity.getUuid());
        return tagEntity;
    }

    public List<TagEntity> findAll() {
        List<TagEntity> res = new ArrayList<>();
        Cursor cursor = db.rawQuery(Queries.SQL_SELECT_ALL_TAG, new String[]{});
        while (cursor.moveToNext()) {
            res.add(TagMapper.getInstance().fromCursor(cursor));
        }
        cursor.close();
        return res;
    }
}
