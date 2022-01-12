package com.example.androit2lessons1.ui.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androit2lessons1.ui.models.News;

@Database(entities = {News.class}, version = 1)
public abstract class Apdatebeic extends RoomDatabase {
    public abstract Newsdawn newsdawn();
}
