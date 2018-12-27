package com.example.ronig.myapplication.GPU;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Activities.MainActivity;
import com.example.ronig.myapplication.CPU.CPU_Main_Tab;
import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.Objects.CPU_Object;
import com.example.ronig.myapplication.Objects.GPU_Object;
import com.example.ronig.myapplication.R;

public class GPU_Tab_1 extends Fragment {

    Button Add_Gpu_Tab_1_Button;
    TextView text;
    TextView price;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gpu_tab_1, container, false);


        Add_Gpu_Tab_1_Button = (Button) rootView.findViewById(R.id.Add_Gpu_Tab1);
        text = (TextView) rootView.findViewById(R.id.Text_Gpu_Tab1);
        price =(TextView) rootView.findViewById(R.id.Price_Gpu_Tab1);


        Add_Gpu_Tab_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Gpu Selected",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);
                getActivity().finish();
                MainActivity.user_gpu= new GPU_Object(text.getText().toString(),price.getText().toString());
            }
        });




        return rootView;
    }

    public void Insert(){

        GPU_Main_Tab.db = new DataBaseHelper(getActivity());
        Cursor cursor = GPU_Main_Tab.db.fetch("gpu");
        cursor.moveToFirst();
        text.setText(cursor.getString(1));
        price.setText(cursor.getString(2));

    }
}
