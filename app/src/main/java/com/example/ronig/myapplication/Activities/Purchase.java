package com.example.ronig.myapplication.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.R;

public class Purchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        TextView pay_Cpu_TextView = (TextView) findViewById(R.id.paytext_cpu);
        TextView pay_Motherboard_TextView = (TextView) findViewById(R.id.paytext_motherboard);
        TextView pay_Memory_TextView = (TextView) findViewById(R.id.paytext_memory);
        TextView pay_SSD_TextView = (TextView) findViewById(R.id.paytext_ssd);
        TextView pay_Gpu_TextView = (TextView) findViewById(R.id.paytext_gpu);
        TextView pay_Case_TextView = (TextView) findViewById(R.id.paytext_case);

        setPayText(pay_Cpu_TextView, MainActivity.user_cpu.getName(),MainActivity.user_cpu.getPrice());
        setPayText(pay_Motherboard_TextView, MainActivity.user_motherboard.getName(),MainActivity.user_motherboard.getPrice());
        setPayText(pay_Memory_TextView, MainActivity.user_ram.getName(),MainActivity.user_ram.getPrice());
        setPayText(pay_SSD_TextView, MainActivity.user_ssd.getName(),MainActivity.user_ssd.getPrice());
        setPayText(pay_Gpu_TextView, MainActivity.user_gpu.getName(),MainActivity.user_gpu.getPrice());
        setPayText(pay_Case_TextView, MainActivity.user_case.getName(),MainActivity.user_case.getPrice() );

    }

    public void setPayText(TextView textView,String name, String price){
        textView.setText(name + " " + price);
    }

}

