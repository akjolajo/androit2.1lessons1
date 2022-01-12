package com.example.androit2lessons1.ui;

import android.app.Application;

import androidx.room.Room;

import com.example.androit2lessons1.ui.room.Apdatebeic;

public class App extends Application {

    private Apdatebeic appDataBase;
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    public Apdatebeic getAppDataBase() {
        return appDataBase;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDataBase = Room
                .databaseBuilder(this,Apdatebeic.class, "database.db")
                .allowMainThreadQueries()
                .build();
    }

}
