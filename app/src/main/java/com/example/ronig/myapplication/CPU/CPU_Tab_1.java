package com.example.ronig.myapplication.CPU;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Activities.MainActivity;
import com.example.ronig.myapplication.Objects.Products.CPU;
import com.example.ronig.myapplication.R;

public class CPU_Tab_1 extends Fragment  {

    Button Add_Cpu_Tab_1_Button;
    TextView text;
    TextView price;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_cpu_tab_1, container, false);

        Add_Cpu_Tab_1_Button = (Button) rootView.findViewById(R.id.Add_Cpu_Tab1);
        text = (TextView) rootView.findViewById(R.id.Text_Cpu_Tab1);
        price =(TextView) rootView.findViewById(R.id.Price_Cpu_Tab1);

       CPU_Main_Tab.Insert(text, price, 1);

        //text.setText(CPU_Main_Tab.array.get(0));
        //price.setText(CPU_Main_Tab.array.get(1));


        Add_Cpu_Tab_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getActivity(),"Cpu Selected",Toast.LENGTH_SHORT).show();
               MainActivity.user_cpu = new CPU(text.getText().toString(),price.getText().toString());

                //Intent i = new Intent(getActivity(),MainActivity.class);
               //startActivity(i);
               //getActivity().finish();
                getActivity().onBackPressed();
              //  Toast.makeText(getActivity(),MainActivity.user_cpu.getPrice(),Toast.LENGTH_LONG).show();

            }
        });

        return rootView;
    }



}
