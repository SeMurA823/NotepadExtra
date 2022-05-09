package com.example.notepadextra.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notepadextra.dao.mappers.NoteMapper;
import com.example.notepadextra.di.ServiceLocator;
import com.example.notepadextra.entities.NoteEntity;
import com.example.notepadextra.entities.TagEntity;
import com.example.notepadextra.utils.Queries;
import com.example.notepadextra.utils.Tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NoteDAO {
    private static NoteDAO instance;

    private final SQLiteDatabase db;


    private NoteDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public static NoteDAO getInstance(SQLiteDatabase db) {
        if (instance == null)
            instance = new NoteDAO(db);
        return instance;
    }

    private final Map<String, TagEntity> cacheTag = new HashMap<>();

    public NoteEntity insert(NoteEntity noteEntity) {
        db.insert(
                Tables.NOTES.name(),
                null,
                NoteMapper.getInstance().toCV(noteEntity)
        );
        return noteEntity;
    }

    public NoteEntity insertWithTags(NoteEntity noteEntity) {
        insert(noteEntity);
        try {
            ServiceLocator.getInstance()
                    .noteTagDAO()
                    .insert(noteEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noteEntity;
    }

    public NoteEntity update(NoteEntity noteEntity) {
        db.update(
                Tables.NOTES.name(),
                NoteMapper.getInstance().toCV(noteEntity),
                "id = ?",
                new String[]{
                        noteEntity.getUuid().toString()
                }
        );
        return noteEntity;
    }

    public NoteEntity updateWithTags(NoteEntity noteEntity) {
        update(noteEntity);
        List<String> oldTagIds = ServiceLocator.getInstance()
                .noteTagDAO()
                .findAllTagIds(noteEntity.getUuid().toString());
        List<String> newTagIds = noteEntity.getTags().stream()
                .map(x -> x.getUuid().toString())
                .collect(Collectors.toList());
        oldTagIds.stream()
                .filter(x -> !newTagIds.contains(x))
                .forEach(x -> ServiceLocator.getInstance()
                        .noteTagDAO().delete(x, noteEntity.getUuid().toString()));
        newTagIds.stream()
                .filter(x -> !oldTagIds.contains(x))
                .forEach(x -> ServiceLocator.getInstance()
                        .noteTagDAO()
                        .insert(x, noteEntity.getUuid().toString()));
        return noteEntity;
    }

    public List<NoteEntity> findAll() {
        Cursor cursor = db.rawQuery(Queries.SQL_SELECT_NOTES_ALL, new String[]{});
        List<NoteEntity> notes = new ArrayList<>();
        while (cursor.moveToNext()) {
            NoteEntity note = NoteMapper.getInstance().fromCursor(cursor);
            note.getTags().addAll(ServiceLocator.getInstance()
                    .noteTagDAO()
                    .findAllTags(note.getUuid().toString()));
            notes.add(note);

        }

        cursor.close();
        return notes;
    }

    public void delete(String id) {
        db.delete(
                Tables.NOTES.name(),
                "id = ?",
                new String[]{id}
        );
    }

    public void delete(NoteEntity noteEntity) {
        delete(noteEntity.getUuid().toString());
    }
}
