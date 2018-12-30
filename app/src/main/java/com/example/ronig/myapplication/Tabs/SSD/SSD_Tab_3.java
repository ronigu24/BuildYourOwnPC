package com.example.ronig.myapplication.Tabs.SSD;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Activities.MainActivity;
import com.example.ronig.myapplication.Objects.Products.SSD;
import com.example.ronig.myapplication.R;

public class SSD_Tab_3 extends Fragment {

    Button Add_Ssd_Tab_3_Button;
    TextView text;
    TextView price;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ssd_tab_3, container, false);


        Add_Ssd_Tab_3_Button = (Button) rootView.findViewById(R.id.Add_Ssd_Tab3);
        text = (TextView) rootView.findViewById(R.id.Text_Ssd_Tab3);
        price =(TextView) rootView.findViewById(R.id.Price_Ssd_Tab3);

        SSD_Main_Tab.Insert(text, price, 3);


        Add_Ssd_Tab_3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Ssd Selected",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getActivity(),MainActivity.class);
                //startActivity(i);
                MainActivity.user_ssd= new SSD(text.getText().toString(),price.getText().toString());
                getActivity().onBackPressed();

            }
        });

        return rootView;
    }
}
