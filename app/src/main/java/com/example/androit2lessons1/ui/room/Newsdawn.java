package com.example.androit2lessons1.ui.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androit2lessons1.ui.models.News;

import java.util.List;

@Dao
public interface Newsdawn {
    @Query("SELECT * FROM news order by createdata DESC")
    List<News> getAll();

    @Query("SELECT * FROM news order by title ASC")
    List<News> getAllSortedtitle();

    @Insert
    void insert(News news);

    @Delete
    void delate(News news);

}
