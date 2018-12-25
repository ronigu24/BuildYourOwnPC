package com.example.ronig.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Products_DataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Products.db";

    // User table name
    private static final String TABLE_CPU = "CPU";

    // User Table Columns names
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_PRICE = "Price";

    // create table sql query
    private String CREATE_CPU_TABLE = "CREATE TABLE " + TABLE_CPU + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";

    // drop table sql query
    private String DROP_CPU_TABLE = "DROP TABLE IF EXISTS " + TABLE_CPU;


    /**
     * Constructor
     *
     * @param context
     */
    public Products_DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CPU_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_CPU_TABLE);

        // Create tables again
        onCreate(db);

    }

}
