package com.example.evans.androidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.lang.reflect.Field;

public class DBHelper extends SQLiteOpenHelper {
    //Information of database
    public static final String DB_NAME = "LOCATION";
    public static final  int   DB_VERSION =1;
    public static final int KEY_ID = 0;
    public static final String KEY_USERID = "userId";
    public static final Float KEY_LONGITUDE = 0.0f;
    public static final Float KEY_LATITUDE = 0.0f;
    public static final String KEY_DT = "timestamp";
        //Initialize the database
    public DBHelper(@Nullable Context context){super(context, DB_NAME, null, DB_VERSION);}

    @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(" CREATE TABLE "+ DB_NAME + " (" +
                KEY_ID+" INT, "+
                KEY_USERID+" TEXT, "+
                KEY_LONGITUDE+" FLOAT, "+
                KEY_LATITUDE+" FLOAT, "+
                KEY_DT+" TEXT, "+
                ");"
        );
    }

    @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){

    }
    //prints out the coordinates that match the userid input.
   /* public String getlocationbyuserid(String name){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DB_NAME,new Float[]{KEY_LATITUDE,KEY_LONGITUDE},"name=?",
                new String[]{name},
                null,null);
        if (cursor.moveToFirst(){
            return cursor.toString();
        }
        return null;
    }
    */
}
