package com.example.podcastlisten.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {
    public static final String PREFERENCIA_EMAIL = "preferencia_email";
    public static final String PREFERENCIA_FILE_KEY = "preferencia_read_with_me";
    SharedPreferences sharedPreferences;
    Context context;
    public Preferencias(Context context){
        this.context = context;
         sharedPreferences = context.getSharedPreferences(PREFERENCIA_FILE_KEY, Context.MODE_PRIVATE);
    }

    public void salvaEmail(String email){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFERENCIA_EMAIL, email);
        editor.apply();
    }

    public String getEmail(){

        String result = sharedPreferences.getString(PREFERENCIA_EMAIL, "");
        return result;
    }

}
