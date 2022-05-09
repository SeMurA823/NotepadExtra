package com.example.notepadextra.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notepadextra.dao.mappers.TagMapper;
import com.example.notepadextra.entities.NoteEntity;
import com.example.notepadextra.entities.TagEntity;
import com.example.notepadextra.utils.Queries;
import com.example.notepadextra.utils.Tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class NoteTagDAO {
    private static NoteTagDAO instance;

    private SQLiteDatabase db;

    public NoteTagDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public static NoteTagDAO getInstance(SQLiteDatabase db) {
        if (instance == null)
            instance = new NoteTagDAO(db);
        return instance;
    }

    public Set<TagEntity> insert(NoteEntity noteEntity) {
        noteEntity.getTags().stream()
                .map(TagEntity::getUuid)
                .forEach(x->insert(x.toString(), noteEntity.getUuid().toString()));
        return noteEntity.getTags();
    }

    public void delete(String tagId, String noteId) {
        db.delete(
                Tables.TAG_NOTE_RELATION.name(),
                "tag_id = ? and note_id = ?",
                new String[]{
                        tagId,
                        noteId
                }
        );
    }

    public void insert(String tagId, String noteId) {
        ContentValues cv = new ContentValues();
        cv.put("tag_id", tagId);
        cv.put("note_id", noteId);
        db.insert(
                Tables.TAG_NOTE_RELATION.name(),
                null,
                cv
        );
    }

    public List<String> findAllTagIds(String noteId) {
        Cursor cursor = db.rawQuery(
                Queries.SQL_SELECT_ALL_TAG_IDS_BY_NOTE_ID,
                new String[]{noteId}
        );
        List<String> ids = new ArrayList<>();
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(0));
        }
        cursor.close();
        return ids;
    }

    public List<TagEntity> findAllTags(String noteId) {
        Cursor cursor = db.rawQuery(
                Queries.SQL_SELECT_ALL_TAGS_BY_NOTE_ID,
                new String[]{noteId}
        );
        List<TagEntity> res = new ArrayList<>();
        while (cursor.moveToNext()) {
            res.add(TagMapper.getInstance().fromCursor(cursor));
        }
        cursor.close();
        return res;
    }
}
