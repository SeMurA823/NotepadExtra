package com.example.notepadextra.dao.mappers;

import android.content.ContentValues;

import com.example.notepadextra.entities.TagEntity;

public class TagMapper {
    private static final TagMapper tagMapper = new TagMapper();

    public static TagMapper getInstance() {
        return tagMapper;
    }

    public ContentValues toCV(TagEntity tagEntity) {
        ContentValues cv = new ContentValues();
        cv.put("name", tagEntity.getName());
        return cv;
    }
}
