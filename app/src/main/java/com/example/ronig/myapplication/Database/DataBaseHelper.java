package com.example.ronig.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ronig.myapplication.Objects.User;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Database1.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_CPU = "cpu";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "ID";
    private static final String COLUMN_USER_NAME = "Username";
    private static final String COLUMN_USER_PASSWORD = "Password";
    private static final String COLUMN_USER_EMAIL = "Email";

    // User Table Columns names
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_PRICE = "Price";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_EMAIL + " TEXT" + ")";

    private String CREATE_CPU_TABLE = "CREATE TABLE " + TABLE_CPU + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    // drop table sql query
    private String DROP_CPU_TABLE = "DROP TABLE IF EXISTS " + TABLE_CPU;
    

    /**
     * Constructor
     *
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_CPU_TABLE);

        // Create tables again
        onCreate(db);

    }


    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_EMAIL, user.getEmail());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean isEmailExists(String Email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,// Selecting Table
                new String[]{COLUMN_USER_ID, COLUMN_USER_NAME, COLUMN_USER_PASSWORD, COLUMN_USER_EMAIL},//Selecting columns want to query
                COLUMN_USER_EMAIL + "=?",
                new String[]{Email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            db.close();
            return true;
        }

        //if email does not exist return false
        db.close();
        return false;
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,// Selecting Table
                new String[]{COLUMN_USER_ID, COLUMN_USER_NAME, COLUMN_USER_PASSWORD, COLUMN_USER_EMAIL},//Selecting columns want to query
                COLUMN_USER_NAME +"=?",
                new String[]{user.getName()},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {

            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

            //Match both passwords check they are same or not
          if (user.getPassword().equalsIgnoreCase(user1.getPassword())) {
              cursor.close();
               return user1;
           }
        }

        //if user password does not matches or there is no record with that email then return @false
        cursor.close();
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_CPU_TABLE);


    }

    public void addProduct(String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);

        // Inserting Row
        db.insert(TABLE_CPU, null, values);
        db.close();
    }


}
