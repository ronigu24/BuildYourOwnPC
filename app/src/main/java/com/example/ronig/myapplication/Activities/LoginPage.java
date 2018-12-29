package com.example.ronig.myapplication.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.Objects.User;
import com.example.ronig.myapplication.R;

import java.io.File;

public class LoginPage extends AppCompatActivity {


    EditText inputUsername, inputPassword;
    Button loginButton, registerButton;
    DataBaseHelper db;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        db = new DataBaseHelper(this);

        sp = getSharedPreferences("myPref", Context.MODE_PRIVATE);



        initViews();


        //set click event of login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check user input is correct or not
                if (validate()) {

                    //Get values from EditText fields
                    String Username = inputUsername.getText().toString();
                    String Password = inputPassword.getText().toString();

                    if (Username.equals("admin")) {
                        Intent i = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(i);
                        finish();
                    } else {

                        //Authenticate user
                        MainActivity.current_user = db.Authenticate(new User(null, Username, Password, null));


                        //Check Authentication is successful or not
                        if (MainActivity.current_user != null) {


                            Toast.makeText(getApplicationContext(), "Successfully Logged in!", Toast.LENGTH_SHORT).show();



                            /* now store your primitive type values. In this case it is true, 1f and Hello! World  */
                            //File f = new File("/data/data/" + getPackageName() +  "/shared_prefs/" + FILENAME + ".xml");
                            if (!Used()) {

                                Log.d("TAG", "Setup default preferences");
                                firstUse();

                            }
                            else {
                                Log.d("TAG", "SharedPreferences myPref : exist");


                            }
                            db.Build_DataBase();

                            // Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                            //   db.addProduct("intel_core_i7_8700k_3_7ghz","1800");
                            //  db.addProduct("Intel Core i5, 6500 4x, 3.2Ghz","930");

                            //User Logged in Successfully Launch You home screen activity

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();

                        } else {

                            //User Logged in Failed
                            Toast.makeText(getApplicationContext(), "Failed to log in , please try again", Toast.LENGTH_SHORT).show();
                            // Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                        }
                    }
                }
            }
        });

        registerButton =(Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterPage.class);
                startActivity(i);
            }
        });
    }

    private void initViews() {
        inputUsername = (EditText) findViewById(R.id.inputUsername);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = true;

        //Get values from EditText fields
        String Username = inputUsername.getText().toString();
        String Password = inputPassword.getText().toString();

        //Handling validation for Password field
        if (Username.isEmpty()) {
            valid = false;
            //textInputLayoutPassword.setError("Please enter valid password!");
            Toast.makeText(getApplicationContext(), "Please enter valid username", Toast.LENGTH_SHORT).show();
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Please enter valid password!", Toast.LENGTH_SHORT).show();
            //textInputLayoutPassword.setError("Please enter valid password!");
        }

        return valid;
    }

    public void firstUse() {

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Used previously", "true");
        editor.commit();

    }

    public boolean Used() {

        if (sp.contains("Used previously")) {
            return true;
        }
        return false;
    }
}
