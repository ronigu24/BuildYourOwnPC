package com.example.ronig.myapplication.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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





        setPayText(paycpu, LoginPage.currentUser.my_pc.cpu_name.getName(), LoginPage.currentUser.my_pc.cpu_name.getPrice());
        setPayText(paymotherboard, LoginPage.currentUser.my_pc.motherboard_name.getName(), LoginPage.currentUser.my_pc.case_name.getPrice());
        setPayText(paymemory, LoginPage.currentUser.my_pc.case_name.getName(), LoginPage.currentUser.my_pc.case_name.getPrice());
        setPayText(payssd, LoginPage.currentUser.my_pc.case_name.getName(), LoginPage.currentUser.my_pc.case_name.getPrice());
        setPayText(paygpu, LoginPage.currentUser.my_pc.case_name.getName(), LoginPage.currentUser.my_pc.case_name.getPrice());
        setPayText(paycase, LoginPage.currentUser.my_pc.case_name.getName(), LoginPage.currentUser.my_pc.case_name.getPrice());


    }

    public void setPayText(TextView textView,String name, int price){
        textView.setText(name + " " + price);
    }

}

