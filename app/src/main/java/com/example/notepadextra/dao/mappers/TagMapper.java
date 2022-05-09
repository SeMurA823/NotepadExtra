package com.example.notepadextra.dao.mappers;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.notepadextra.entities.TagEntity;

import java.util.UUID;

public class TagMapper {
    private static final TagMapper tagMapper = new TagMapper();

    public static TagMapper getInstance() {
        return tagMapper;
    }

    public ContentValues toCV(TagEntity tagEntity) {
        ContentValues cv = new ContentValues();
        cv.put("id", tagEntity.getUuid().toString());
        cv.put("name", tagEntity.getName());
        return cv;
    }

    public TagEntity fromCursor(Cursor cursor) {
        UUID uuid = UUID.fromString(cursor.getString(0));
        String name = cursor.getString(1);
        return new TagEntity(uuid, name);
    }
}
