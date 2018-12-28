package com.example.ronig.myapplication.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.CPU.CPU_Main_Tab;
import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.R;

public class Purchase extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Button pay_Btn = (Button) findViewById(R.id.pay);
        TextView pay_Cpu_TextView = (TextView) findViewById(R.id.paytext_cpu);
        TextView pay_Motherboard_TextView = (TextView) findViewById(R.id.paytext_motherboard);
        TextView pay_Memory_TextView = (TextView) findViewById(R.id.paytext_memory);
        TextView pay_SSD_TextView = (TextView) findViewById(R.id.paytext_ssd);
        TextView pay_Gpu_TextView = (TextView) findViewById(R.id.paytext_gpu);
        TextView pay_Case_TextView = (TextView) findViewById(R.id.paytext_case);
        TextView Price_TextView = (TextView) findViewById(R.id.Price);

        setPayText(pay_Cpu_TextView, MainActivity.user_cpu.print());
        setPayText(pay_Motherboard_TextView, MainActivity.user_motherboard.print());
        setPayText(pay_Memory_TextView, MainActivity.user_ram.print());
        setPayText(pay_SSD_TextView, MainActivity.user_ssd.print());
        setPayText(pay_Gpu_TextView, MainActivity.user_gpu.print());
        setPayText(pay_Case_TextView, MainActivity.user_case.print() );
        setPayText(Price_TextView, MainActivity.user_pc.printsum());

        pay_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CPU_Main_Tab.db.addOrder();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void setPayText(TextView textView,String print){
        textView.setText(print);
    }

}

