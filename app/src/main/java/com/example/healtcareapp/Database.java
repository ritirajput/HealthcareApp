package com.example.healtcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
        public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 String qry1 = "create table users( username txt, email txt, password txt )";
 db.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username, String email, String password, String conpassword){
        ContentValues cv = new ContentValues();
        cv.put("Username", username);
        cv.put("Email", email);
        cv.put("Password", password);
        cv.put("Confirm Password", conpassword);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users" , null,cv);
        db.close();
    }
}
