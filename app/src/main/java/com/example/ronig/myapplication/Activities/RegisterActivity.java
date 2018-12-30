package com.example.ronig.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.Objects.User;
import com.example.ronig.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    DataBaseHelper db;
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        db = new DataBaseHelper(this);

        initViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    String Email = editTextEmail.getText().toString();


                    if (!db.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        db.addUser(new User(null, UserName, Password, Email));
                        Toast.makeText(getApplicationContext(), "User created successfully! Please Login", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(i);
                        finish();

                    } else {

                        //Email exists with email input provided so show error user already exist
                        Toast.makeText(getApplicationContext(), "User already exists with same email", Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });
    }

    private void initViews() {
        editTextUserName = (EditText) findViewById(R.id.username_Input);
        editTextPassword = (EditText) findViewById(R.id.password_Input);
        editTextEmail = (EditText) findViewById(R.id.email_Input);
        registerButton = (Button) findViewById(R.id.submit_btn);
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = true;

        //Get values from EditText fields
        String Username = editTextUserName.getText().toString();
        String Password = editTextPassword.getText().toString();
        String Email = editTextEmail.getText().toString();

        //Handling validation for Password field
        if (Username.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Please enter valid username", Toast.LENGTH_SHORT).show();
        }

        else if (Username.length() < 5) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Username is to short!", Toast.LENGTH_SHORT).show();
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Please enter valid password!", Toast.LENGTH_SHORT).show();
        }

        else if (Password.length() < 5) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Password is to short!", Toast.LENGTH_SHORT).show();
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Toast.makeText(getApplicationContext(), "Please enter valid email!", Toast.LENGTH_SHORT).show();

        }
            return valid;
    }
}
