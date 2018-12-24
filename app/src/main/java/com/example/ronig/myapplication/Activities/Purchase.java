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



        TextView paycpu = (TextView) findViewById(R.id.paytext_cpu);
        TextView paymotherboard = (TextView) findViewById(R.id.paytext_motherboard);
        TextView paymemory = (TextView) findViewById(R.id.paytext_memory);
        TextView payssd = (TextView) findViewById(R.id.paytext_ssd);
        TextView paygpu = (TextView) findViewById(R.id.paytext_gpu);
        TextView paycase = (TextView) findViewById(R.id.paytext_case);





        paycpu.setText("hello");

        //setPayText(paycpu, MainActivity.current_user.my_pc.cpu_name.getName(),MainActivity.current_user.my_pc.cpu_name.getPrice());
       // setPayText(paymotherboard, MainActivity.user_case.getName(),MainActivity.user_motherboard.getPrice());
       // setPayText(paymemory, MainActivity.user_case.getName(),MainActivity.user_ram.getPrice());
       // setPayText(payssd, MainActivity.user_case.getName(),MainActivity.user_ssd.getPrice());
       // setPayText(paygpu, MainActivity.user_case.getName(),MainActivity.user_gpu.getPrice());
       // setPayText(paycase, MainActivity.user_case.getName(),MainActivity.user_case.getPrice() );


    }

    public void setPayText(TextView textView,String name, String price){
        textView.setText(name + " " + price);
    }

}

