package com.example.ronig.myapplication.Tabs.CPU;

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

public class CPU_Tab_4 extends Fragment {

    Button Add_Cpu_Tab_4_Button;
    TextView text;
    TextView price;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cpu_tab_4, container, false);

        Add_Cpu_Tab_4_Button = (Button) rootView.findViewById(R.id.Add_Cpu_Tab4);
        text = (TextView) rootView.findViewById(R.id.Text_Cpu_Tab4);
        price =(TextView) rootView.findViewById(R.id.Price_Cpu_Tab4);

        CPU_Main_Tab.Insert(text, price, 4);

        Add_Cpu_Tab_4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Cpu Selected",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getActivity(),MainActivity.class);
                //startActivity(i);
                MainActivity.user_cpu= new CPU(text.getText().toString(),price.getText().toString());
                getActivity().onBackPressed();
            }
        });

        return rootView;
    }
}