package com.example.ronig.myapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.R;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    private static final String TAG = "AdminActivity";

    private ArrayList<String> names = new ArrayList<>();
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        db = new DataBaseHelper(this);
        names = db.myOrder();

        initRecyclerView();


    }


    public void refresh() {

        finish();
        startActivity(getIntent());
    }

    private void initRecyclerView(){
        Log.i(TAG, "initRecyclerView: Init Recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);
    }
}
