package com.example.notepadextra.dao.mappers;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.notepadextra.entities.NoteEntity;
import com.example.notepadextra.entities.TagEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

public class NoteMapper {
    private static final NoteMapper tagMapper = new NoteMapper();

    public static NoteMapper getInstance() {
        return tagMapper;
    }

    /*
        id text primary key, date date, title text, description text
     */

    private Map<UUID, TagEntity> cacheTagEntity = new HashMap<>();

    public ContentValues toCV(NoteEntity noteEntity) {
        ContentValues cv = new ContentValues();
        cv.put("id", noteEntity.getUuid().toString());
        cv.put("title", noteEntity.getTitle());
        cv.put("description", noteEntity.getText());
        cv.put("date", noteEntity.getDate().toString());
        return cv;
    }

    public NoteEntity fromCursor(Cursor cursor) {
        UUID uuid = UUID.fromString(cursor.getString(0));
        LocalDate date = LocalDate.parse(cursor.getString(1));
        String title = cursor.getString(2);
        String description = cursor.getString(3);

        return new NoteEntity(uuid,
                title,
                description,
                date,
                new TreeSet<>(Comparator.comparing(TagEntity::getName)));
    }
}
