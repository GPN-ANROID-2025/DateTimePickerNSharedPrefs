package com.example.datepickertimepickerdialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPrefs {

    SharedPreferences sharedPreferences;
    Context mContext;
    SharedPreferences.Editor editor;

    public static final String KEY_NAME="name";
    MyPrefs(Context context)
    {
        this.mContext=context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }

    public void  clearAll(){
        editor.clear();
        editor.commit();
        editor.apply();
    }

    public void setName(String name){

        editor.putString(KEY_NAME,name);
        editor.commit();
    }

    public String getName(){

        return sharedPreferences.getString(KEY_NAME,"NULL");
    }
}
