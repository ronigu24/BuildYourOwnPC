package com.example.ronig.myapplication.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.Objects.User;
import com.example.ronig.myapplication.R;
import org.json.JSONException;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    EditText inputUsername, inputPassword;
    Button loginButton, registerButton;
    DataBaseHelper db;

    //SharedPreferences sp;


    public static class DownloadCancelReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            System.out.println("Received Cancelled Event");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        db = new DataBaseHelper(this);

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

                    if (Username.equals("admin") && Password.equals("admin")) {

                        MainActivity.current_user = new User(null, Username, Password, null);
                        Intent i = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(i);
                        finish();

                    } else {

                        //Authenticate user
                        MainActivity.current_user = db.Authenticate(new User(null, Username, Password, null));

                        //Check Authentication is successful or not
                        if (MainActivity.current_user != null) {

                            Toast.makeText(getApplicationContext(), "Successfully Logged in!", Toast.LENGTH_SHORT).show();

                            try {
                                initDataBase();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(TAG, e.toString());
                                System.exit(-1);
                            }

                            //User Logged in Successfully Launch You home screen activity
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();

                        } else {

                            //User Logged in Failed
                            Toast.makeText(getApplicationContext(), "Failed to log in , please try again", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }
        });

        registerButton =(Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
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
            Toast.makeText(getApplicationContext(), "Please enter valid username", Toast.LENGTH_SHORT).show();
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Please enter valid password!", Toast.LENGTH_SHORT).show();

        }

        return valid;
    }

    private void initDataBase() throws IOException, JSONException {

        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences("myPreference",Context.MODE_PRIVATE);
        boolean firstTime = sharedPref.getBoolean("Login by user", true);

        if(firstTime) {
            Log.d(TAG, "First entry of this device");
            SharedPreferences.Editor sharedpref = sharedPref.edit();
            sharedpref.putBoolean("Reload the Database!", false);
            sharedpref.commit();
            db.Build_DataBase();
        }

        else {
            Log.d(TAG, "Don't reload the Database!");
        }

    }

}