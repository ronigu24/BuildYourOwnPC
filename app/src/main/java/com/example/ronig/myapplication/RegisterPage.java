package com.example.ronig.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {



    SQLiteOpenHelper OpenHelper;
    SQLiteDatabase db;
    EditText username_Input, password_Input, email_Input;
    Button submit_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);



        username_Input = (EditText)findViewById(R.id.username_Input);
        password_Input = (EditText)findViewById(R.id.password_Input);
        email_Input = (EditText)findViewById(R.id.email_Input);
        submit_btn = (Button)findViewById(R.id.submit_btn);

        OpenHelper = new DataBaseHelper(this);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = OpenHelper.getWritableDatabase();
                String username = username_Input.getText().toString();
                String pass = password_Input.getText().toString();
                String mail = email_Input.getText().toString();
                insertdata(username, pass, mail);
                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

            }

        });


            }

            public void insertdata(String username, String password, String mail) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DataBaseHelper.COl_2, username);
                contentValues.put(DataBaseHelper.COl_3, password);
                contentValues.put(DataBaseHelper.COl_4, mail);
                long id = db.insert(DataBaseHelper.TABLE_NAME, null, contentValues);
            }
        }

