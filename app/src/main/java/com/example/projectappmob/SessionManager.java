package com.example.projectappmob;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.projectappmob.model.login.LoginData;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER = "id_user";
    public static final String USERNAME = "username";
    public static final String NAMA_LENGKAP = "nama_lengkap";
    public static final String EMAIL = "email";
    public static final String NOHP = "no_hp";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putInt(ID_USER, user.getIdUser());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(NAMA_LENGKAP, user.getNamaLengkap());
        editor.putString(EMAIL, user.getEmail());
        editor.putInt(NOHP, user.getNoHp());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_USER, String.valueOf(sharedPreferences.getInt(ID_USER, 0)));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(NAMA_LENGKAP, sharedPreferences.getString(NAMA_LENGKAP,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(NOHP, String.valueOf(sharedPreferences.getInt(NOHP, 0)));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
