package com.example.ronig.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.ronig.myapplication.Activities.MainActivity;
import com.example.ronig.myapplication.Objects.CPU_Object;
import com.example.ronig.myapplication.Objects.Case_Object;
import com.example.ronig.myapplication.Objects.GPU_Object;
import com.example.ronig.myapplication.Objects.Memory_Object;
import com.example.ronig.myapplication.Objects.MotherBoard_Object;
import com.example.ronig.myapplication.Objects.Order;
import com.example.ronig.myapplication.Objects.Product;
import com.example.ronig.myapplication.Objects.SSD_Object;
import com.example.ronig.myapplication.Objects.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Database8.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_CPU = "cpu";
    private static final String TABLE_GPU = "gpu";
    private static final String TABLE_RAM = "ram";
    private static final String TABLE_MOTHERBOARD = "motherboard";
    private static final String TABLE_SSD = "SSD";
    private static final String TABLE_CASE = "case_";
    private static final String TABLE_ORDERS = "orders";


    // User Table Columns names
    private static final String COLUMN_USER_ID = "ID";
    private static final String COLUMN_USER_NAME = "Username";
    private static final String COLUMN_USER_PASSWORD = "Password";
    private static final String COLUMN_USER_EMAIL = "Email";

    // User Table Columns names
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_PRICE = "Price";


    //  Product Table Columns names

    private static final String COLUMN_STATUS = "Status";
    private static final String COLUMN_TOTAL_PRICE = "TotalPrice";
    private static final String COLUMN_USER_ORDER = "UserOrder";
    private static final String COLUMN_ID_ORDER ="ID";



    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_EMAIL + " TEXT" + ")";

    private String CREATE_CPU_TABLE = "CREATE TABLE " + TABLE_CPU + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";
    private String CREATE_MOTHERBOARD_TABLE = "CREATE TABLE " + TABLE_MOTHERBOARD + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";

    private String CREATE_RAM_TABLE = "CREATE TABLE " + TABLE_RAM + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";
    private String CREATE_SSD_TABLE = "CREATE TABLE " + TABLE_SSD + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";
    private String CREATE_GPU_TABLE = "CREATE TABLE " + TABLE_GPU + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";
    private String CREATE_CASE_TABLE = "CREATE TABLE " + TABLE_CASE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_PRICE + " TEXT" + ")";
    private String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
            + COLUMN_ID_ORDER + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_ORDER + " TEXT,"
            + COLUMN_TOTAL_PRICE + " TEXT, " + COLUMN_STATUS + " TEXT" + ")";




    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    private String DROP_CPU_TABLE = "DROP TABLE IF EXISTS " + TABLE_CPU;
    private String DROP_MOTHERBOARD_TABLE = "DROP TABLE IF EXISTS " + TABLE_MOTHERBOARD;
    private String DROP_RAM_TABLE = "DROP TABLE IF EXISTS " + TABLE_RAM;
    private String DROP_SSD_TABLE = "DROP TABLE IF EXISTS " + TABLE_SSD;
    private String DROP_GPU_TABLE = "DROP TABLE IF EXISTS " + TABLE_GPU;
    private String DROP_CASE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CASE;
    private String DROP_ORDERS_TABLE = "DROP TABLE IF EXISTS " + TABLE_ORDERS;


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
        db.execSQL(DROP_MOTHERBOARD_TABLE);
        db.execSQL(DROP_RAM_TABLE);
        db.execSQL(DROP_SSD_TABLE);
        db.execSQL(DROP_GPU_TABLE);
        db.execSQL(DROP_CASE_TABLE);
        db.execSQL(DROP_ORDERS_TABLE);

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
        db.execSQL(CREATE_MOTHERBOARD_TABLE);
        db.execSQL(CREATE_RAM_TABLE);
        db.execSQL(CREATE_SSD_TABLE);
        db.execSQL(CREATE_GPU_TABLE);
        db.execSQL(CREATE_CASE_TABLE);
        db.execSQL(CREATE_ORDERS_TABLE);


    }

    public void addProduct(String name, String price,String Table_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);

        // Inserting Row
        db.insert(Table_name, null, values);

        db.close();
    }

    public void changeStatus(String status, int id){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS, status);

        db.update(TABLE_ORDERS,values,COLUMN_ID_ORDER+"="+id, null );

        db.close();
    }


    public ArrayList<Order> myOrder() {

        ArrayList<Order> array = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        Log.i("SQLite", "DataBaseHelper myOrder function");


        if(MainActivity.current_user.getName().equals("admin")){
             cursor = db.rawQuery("select * from " + TABLE_ORDERS, null);
        }
        //Cursor cursor = db.query(table_Name, new String[]{COLUMN_NAME, COLUMN_PRICE}, COLUMN_ID, null, null, null, null);
       else {
             cursor = db.rawQuery("select * from " + TABLE_ORDERS + " WHERE " + COLUMN_USER_ORDER + " = " + "'" + MainActivity.current_user.getName() + "'", null);
        }
        String name, price, status;

        if (cursor.moveToFirst()) {

            name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ORDER));
            price = cursor.getString(cursor.getColumnIndex(COLUMN_TOTAL_PRICE));
            status = cursor.getString(cursor.getColumnIndex(COLUMN_STATUS));
            array.add(new Order(name,price,status));

            while (cursor.moveToNext()) {

                name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ORDER));
                price = cursor.getString(cursor.getColumnIndex(COLUMN_TOTAL_PRICE));
                status = cursor.getString(cursor.getColumnIndex(COLUMN_STATUS));

                array.add(new Order(name,price,status));

            }

        }
            cursor.close();
            db.close();
return array;
        }






    public void addOrder()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

       // values.put(COLUMN_ID_ORDER, "1");
        values.put(COLUMN_USER_ORDER, MainActivity.current_user.getName());
        values.put(COLUMN_TOTAL_PRICE, MainActivity.current_user.my_pc.totalprice);
        values.put(COLUMN_STATUS, "Order pending approval");

        // Inserting Row
        db.insert(TABLE_ORDERS, null, values);

        db.close();

    }

    public void Build_DataBase ()
    {

       Product component_arr[]= new Product[4];
        component_arr[0]=new CPU_Object("intel_core_i7_8700k_3_7ghz!", "1800 ₪");
        component_arr[1]=new CPU_Object("Intel Core i5, 6500 4x, 3.2Ghz!", "930 ₪");
        component_arr[2]=new CPU_Object("intel_core_i3_8100_8th_genaration!", "670 ₪");
        component_arr[3]=new CPU_Object("amd_ryzen_7_1800x_8_cores_3_6ghz!", "1120 ₪");

        for(int i=0; i<component_arr.length; i++)
        {
            addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_CPU);
        }

        component_arr[0]=new MotherBoard_Object("gigabyte_z97x_gaming_5", "750 ₪");
        component_arr[1]=new MotherBoard_Object("intel_b360_aorus_motherboard_with_rgb_fusion_with_digital_leds", "610 ₪");
        component_arr[2]=new MotherBoard_Object("intel_h370_ultra_durable_motherboard", "430 ₪");
        component_arr[3]=new MotherBoard_Object("gigabyte_unveils_new_990fx_and_970_gaming_motherboards_amd_fx", "330 ₪");

       for(int i=0; i<component_arr.length; i++)
       {
           addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_MOTHERBOARD);
       }

        component_arr[0]=new Memory_Object("fury_hyperx_ddr4_8gb", "360 ₪");
        component_arr[1]=new Memory_Object("G.SKILL DDR4 32GB Memory Kit 4400MHz", "2320 ₪");
        component_arr[2]=new Memory_Object("G.Skill Announces 32GB DDR4-4266MHz Trident Z RGB Memory Kits", "2110 ₪");
        component_arr[3]=new Memory_Object("DDR4_RAM-4-8GB-2133", "435 ₪");

        for(int i=0; i<component_arr.length; i++)
        {
            addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_RAM);
        }

        component_arr[0]=new SSD_Object("samsung_ssd_evo_970_1tb", "750 ₪");
        component_arr[1]=new SSD_Object("SanDisk SSD PLUS SDSSDA240G 240GB", "220 ₪");
        component_arr[2]=new SSD_Object("Kingston SSDNow V100 128GB SSD", "110 ₪");
        component_arr[3]=new SSD_Object("Corsair Force LE200 120GB SSD Sata III 2.5'' 550/500 Mb/s", "100 ₪");

        for(int i=0; i<component_arr.length; i++)
        {
            addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_SSD);
        }

        component_arr[0]=new GPU_Object("MSI R9 390 GAMING 8G Graphics Card", "1420 ₪");
        component_arr[1]=new GPU_Object("gtx_1050_ti_4gb", "830 ₪");
        component_arr[2]=new GPU_Object("gigabyte_gtx_950_2gb", "450 ₪");
        component_arr[3]=new GPU_Object("geforce_gtx_1070_windforce_8g", "2200 ₪");

        for(int i=0; i<component_arr.length; i++)
        {
            addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_GPU);
        }

        component_arr[0]=new Case_Object("Cougar mx350 tg", "399 ₪");
        component_arr[1]=new Case_Object("Game Max Eclipse RGB Tempered Glass Midi PC Gaming Case", "370 ₪");
        component_arr[2]=new Case_Object("Cougar MX310", "200 ₪");
        component_arr[3]=new Case_Object("Corsair SPEC-03 Red", "299 ₪");

        for(int i=0; i<component_arr.length; i++)
        {
            addProduct(component_arr[i].getName(),component_arr[i].getPrice(),TABLE_CASE);
        }

    }


    public ArrayList<String> fetch(String table_Name) {
        ArrayList<String> array = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Log.i("SQLite","DataBaseHelper fetch function");

        //Cursor cursor = db.query(table_Name, new String[]{COLUMN_NAME, COLUMN_PRICE}, COLUMN_ID, null, null, null, null);
        Cursor cursor = db.rawQuery("select * from "+table_Name,null);

        String name, price;


        if(cursor.moveToFirst()) {

             name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            array.add(name);
             price = cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));
            array.add(price);

            while (cursor.moveToNext()) {

                 name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                array.add(name);
                 price = cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));
                array.add(price);

                //cursor.moveToNext();
            }
        }
        /*if (cursor != null) {
            cursor.moveToFirst();
        }*/
        cursor.close();
        db.close();
        return array;
    }
}
