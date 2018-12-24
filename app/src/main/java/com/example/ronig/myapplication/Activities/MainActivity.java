package com.example.ronig.myapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.ronig.myapplication.CPU.CPU_Main_Tab;
import com.example.ronig.myapplication.Case.Case_Main_Tab;
import com.example.ronig.myapplication.GPU.GPU_Main_Tab;
import com.example.ronig.myapplication.Memory.Memory_Main_Tab;
import com.example.ronig.myapplication.MotherBoard.MotherBoard_Main_Tab;
import com.example.ronig.myapplication.R;
import com.example.ronig.myapplication.SSD.SSD_Main_Tab;

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
                Intent i = new Intent(getApplicationContext(),Purchase.class);
                startActivity(i);
            }



        });

        cpubutt =(Button)findViewById(R.id.cpu);
        cpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CPU_Main_Tab.class);
                startActivity(i);
            }
        });

        motherbutt =(Button)findViewById(R.id.motherBoard);
        motherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MotherBoard_Main_Tab.class);
                startActivity(i);
            }
        });

        memorybutt =(Button)findViewById(R.id.memory);
        memorybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Memory_Main_Tab.class);
                startActivity(i);
            }



        });

        ssdbutt =(Button)findViewById(R.id.ssd);
        ssdbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SSD_Main_Tab.class);
                startActivity(i);
            }
        });
        casebutt =(Button)findViewById(R.id.case1);
        casebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Case_Main_Tab.class);
                startActivity(i);
            }
        });

        gpubutt =(Button)findViewById(R.id.gpu);
        gpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GPU_Main_Tab.class);
                startActivity(i);
            }
        });



    }


        }

