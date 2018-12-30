package com.example.ronig.myapplication.MotherBoard;

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
import com.example.ronig.myapplication.Objects.Products.MotherBoard;
import com.example.ronig.myapplication.R;

public class MotherBoard_Tab_1 extends Fragment {

    Button Add_Mother_Tab_1_Button;
    TextView text;
    TextView price;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_motherboard_tab_1, container, false);


        Add_Mother_Tab_1_Button = (Button) rootView.findViewById(R.id.Add_Mother_Tab1);
        text = (TextView) rootView.findViewById(R.id.Text_Mother_Tab1);
        price =(TextView) rootView.findViewById(R.id.Price_Mother_Tab1);

        MotherBoard_Main_Tab.Insert(text, price, 1);

        Add_Mother_Tab_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"MotherBoard Selected",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getActivity(),MainActivity.class);
                //startActivity(i);
                //getActivity().finish();
                MainActivity.user_motherboard= new MotherBoard(text.getText().toString(),price.getText().toString());
                getActivity().onBackPressed();

            }
        });



        return rootView;
    }


}
