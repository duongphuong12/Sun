package com.example.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {
    private  SharedPreferences preferences;
    private static ShareUtils shareUtils;
    public static String KEY_USER_NAME = "key_user_name";
    public static String KEY_PASSWORD = "key_password";
    //singleton
    public static ShareUtils  getInstance(Context context){
        if (shareUtils == null){
            shareUtils =new ShareUtils(context);
        }
        return shareUtils;
    }
    public void putString(String key, String value){
        preferences.edit().putString(key,value).commit();

    }
    public String getString(String key){
        return preferences.getString(key, null);

    }

    public ShareUtils(Context context) {
        preferences = context.getSharedPreferences("ShareUtils",
                Context.MODE_PRIVATE);
    }
}
