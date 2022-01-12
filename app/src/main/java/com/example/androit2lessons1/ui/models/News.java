package com.example.androit2lessons1.ui.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class News implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private long createdata;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedata() {
        return createdata;
    }

    public void setCreatedata(long createdata) {
        this.createdata = createdata;
    }

    public News(String title, long createdata) {
        this.title = title;
        this.createdata = createdata;
    }
}
