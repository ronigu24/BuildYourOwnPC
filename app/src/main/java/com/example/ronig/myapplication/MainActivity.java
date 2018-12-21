package com.example.ronig.myapplication;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buybutt;
    Button cpubutt;
    Button motherbutt;
    Button memorybutt;
    Button ssdbutt;
    Button casebutt;
    Button gpubutt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        buybutt =(Button)findViewById(R.id.buy);
        buybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),purchase.class);
                startActivity(i);
            }



        });

        cpubutt =(Button)findViewById(R.id.cpu);
        cpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),cpu.class);
                startActivity(i);
            }
        });

        motherbutt =(Button)findViewById(R.id.motherBoard);
        motherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),motherboard.class);
                startActivity(i);
            }
        });

        memorybutt =(Button)findViewById(R.id.memory);
        memorybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),memory.class);
                startActivity(i);
            }



        });

        ssdbutt =(Button)findViewById(R.id.ssd);
        ssdbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ssd.class);
                startActivity(i);
            }
        });
        casebutt =(Button)findViewById(R.id.case1);
        casebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Case.class);
                startActivity(i);
            }
        });

        gpubutt =(Button)findViewById(R.id.gpu);
        gpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),gpu.class);
                startActivity(i);
            }
        });



    }


        }

