package com.example.notepadextra.utils;

public interface Queries {
    String SQL_CREATE_TAG_TABLE = String.format("create table if not exists %s (id text primary key, name text)",
            Tables.TAGS.name());
    String SQL_DROP_TAG_TABLE = String.format("drop table if exists %s", Tables.TAGS.name());
    String SQL_SELECT_ALL_TAG = String.format("select id, name from %s order by name", Tables.TAGS.name());

    String SQL_CREATE_TAG_NOTE_RELATION_TABLE = String.format(
            "create table if not exists %s (tag_id text references %s(id) on delete cascade, note_id references %s(id) on delete cascade, PRIMARY KEY (tag_id, note_id))",
            Tables.TAG_NOTE_RELATION.name(),
            Tables.TAGS.name(),
            Tables.NOTES.name()
    );
    String SQL_DROP_TAG_NOTE_RELATION_TABLE = String.format("drop table if exists %s", Tables.TAG_NOTE_RELATION.name());

    String SQL_CREATE_NOTE_TABLE = String.format(
            "create table if not exists %s (id text primary key, date date, title text, description text)",
            Tables.NOTES.name()
    );
    String SQL_DROP_NOTE_TABLE = String.format("drop table if exists %s", Tables.TAG_NOTE_RELATION.name());

    String SQL_SELECT_ALL_TAG_IDS_BY_NOTE_ID = String.format(
            "select tag_id from %s where note_id = ?", Tables.TAG_NOTE_RELATION.name()
    );

    String SQL_SELECT_NOTES_ALL = String.format(
            "select id, date, title, description from %s order by date, title",
            Tables.NOTES.name()
    );

    String SQL_SELECT_ALL_TAGS_BY_NOTE_ID = String.format(
            "select tag.id, tag.name from %s t join %s tag on t.tag_id = tag.id where t.note_id = ?",
            Tables.TAG_NOTE_RELATION.name(),
            Tables.TAGS.name()
    );
}
