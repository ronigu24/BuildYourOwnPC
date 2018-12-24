package com.example.ronig.myapplication.GPU;

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
import com.example.ronig.myapplication.Objects.GPU_Object;
import com.example.ronig.myapplication.R;

public class GPU_Tab_2 extends Fragment {

    Button Add_Gpu_Tab_2_Button;
    TextView text;
    TextView price;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gpu_tab_2, container, false);


        Add_Gpu_Tab_2_Button = (Button) rootView.findViewById(R.id.Add_Gpu_Tab2);
        text = (TextView) rootView.findViewById(R.id.Text_Gpu_Tab2);
        price =(TextView) rootView.findViewById(R.id.Price_Gpu_Tab2);


        Add_Gpu_Tab_2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Gpu Selected",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);
                MainActivity.user_gpu= new GPU_Object(text.getText().toString(),price.getText().toString());

            }
        });




        return rootView;
    }
}
