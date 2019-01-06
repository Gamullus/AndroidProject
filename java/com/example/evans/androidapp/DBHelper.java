package com.example.evans.androidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    //Information of database
    public static final String DB_NAME = "LOCATION";
    public static final  int   DB_VERSION =1;
    public static final String KEY_ID = "Id";
    //Lables table name
    public static final String TABLE_LOC_NAME = "location_table";
    public static final String KEY_USERID = "UserId";
    public static final String KEY_LONGITUDE = "Longitude";
    public static final String KEY_LATITUDE = "Latitude";
    public static final String KEY_DT = "Timestamp";
        //Initialize the database
    public DBHelper(@Nullable Context context){super(context, DB_NAME, null, DB_VERSION);}

    @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(" CREATE TABLE "+ TABLE_LOC_NAME + " ( " +
                KEY_ID+" TEXT, "+
                KEY_USERID+" TEXT, "+
                KEY_LONGITUDE+" FLOAT, "+
                KEY_LATITUDE+" FLOAT, "+
                KEY_DT+" TEXT "+
                ");"
        );
    }


    @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
            //Drop older table if existed
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_LOC_NAME);
            //Create table again
            onCreate(sqLiteDatabase);
    }

    public void Insert(ContentValues values, SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.insert(DB_NAME,null,values);
    }

    public List<String> getDT(){
        List<String> dt = new ArrayList<String>();

        // Select Timestamp column
        String selectQuery = " SELECT " + KEY_DT + " FROM "+ TABLE_LOC_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                dt.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning dt
        return dt;
    }

}
