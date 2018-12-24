package com.example.ronig.myapplication.CPU;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.R;

public class CPU_Tab_1 extends Fragment {

    Button Add_Cpu_Tab_1_Button;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cpu_tab_1, container, false);

        Add_Cpu_Tab_1_Button = (Button) rootView.findViewById(R.id.Add_Cpu_Tab_1_Button);
        text = (TextView) rootView.findViewById(R.id.textView3);

        Add_Cpu_Tab_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Hello",Toast.LENGTH_SHORT).show();
            }
        });










        return rootView;
    }
}
