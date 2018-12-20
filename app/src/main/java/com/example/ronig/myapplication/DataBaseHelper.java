package com.example.ronig.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.DatabaseErrorHandler;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Users.db";
    public static final String TABLE_NAME="User";
    public static final String COl_1="ID";
    public static final String COl_2="UserName";
    public static final String COl_3="Password";
    public static final String COl_4="Email";




    public DataBaseHelper( Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +TABLE_NAME+ " ( INTEGER PRIMARY KEY AUTOINCREMENT, " + COl_2 +"TEXT" + COl_3 +"TEXT" + COl_4 + "TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE EXISTS" + TABLE_NAME);

        onCreate(db);

    }

}
