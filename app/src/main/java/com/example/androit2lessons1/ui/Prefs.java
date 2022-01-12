package com.example.androit2lessons1.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import java.util.jar.Attributes;

public class Prefs {
    private SharedPreferences sharedPreferences;

    public Prefs(Context context) {
        sharedPreferences = context.getSharedPreferences("setings", Context.MODE_PRIVATE);

    }

    public void saveBoardState() {
        sharedPreferences.edit().putBoolean("isShoun", true).apply();
    }

    public boolean isBoarSown() {
        return sharedPreferences.getBoolean("isShoun", false);
    }

    public void sevaImageState(Uri uri) {
        sharedPreferences.edit().putString("isimage", uri.toString()).apply();
    }

    public String isImageSown() {
        return sharedPreferences.getString("isimage", "");
    }

    public void sevaTextState(String name) {
        sharedPreferences.edit().putString("isText", name).apply();
    }

    public String isTextSown() {
        return sharedPreferences.getString("isText", null);
    }
}
