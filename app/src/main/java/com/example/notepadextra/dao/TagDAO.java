package com.example.notepadextra.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.notepadextra.dao.mappers.TagMapper;
import com.example.notepadextra.entities.TagEntity;

public class TagDAO {

    private final SQLiteDatabase db;

    public TagDAO(SQLiteDatabase db) {
        this.db = db;
    }


    private TagEntity update(TagEntity tagEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", tagEntity.getName());
        int update = db.update(Tables.TAGS.name(),
                contentValues,
                "id = ?",
                new String[]{String.valueOf(tagEntity.getId())});
        return tagEntity;
    }

    private TagEntity insert(TagEntity tagEntity) {
        long insert = db.insert(
                Tables.TAGS.name(),
                null,
                TagMapper.getInstance().toCV(tagEntity)
        );
        return tagEntity;
    }

    private int delete(long id) {
        return db.delete(Tables.TAGS.name(),
                "id = ?",
                new String[]{String.valueOf(id)});
    }

    private TagEntity delete(TagEntity tagEntity) {
        delete(tagEntity.getId());
        return tagEntity;
    }
}
