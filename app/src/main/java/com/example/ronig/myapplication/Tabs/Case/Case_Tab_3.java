package com.example.ronig.myapplication.Tabs.Case;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Activities.MainActivity;
import com.example.ronig.myapplication.Objects.Products.Case;
import com.example.ronig.myapplication.R;

public class Case_Tab_3 extends Fragment {

    Button Add_Case_Tab_3_Button;
    TextView text;
    TextView price;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_case_tab_3, container, false);

        Add_Case_Tab_3_Button = (Button) rootView.findViewById(R.id.Add_Case_Tab3);
        text = (TextView) rootView.findViewById(R.id.Text_Case_Tab3);
        price =(TextView) rootView.findViewById(R.id.Price_Case_Tab3);

        Case_Main_Tab.Insert(text, price, 3);

        Add_Case_Tab_3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Case Selected",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getActivity(),MainActivity.class);
                //startActivity(i);
                MainActivity.user_case= new Case(text.getText().toString(),price.getText().toString());
                getActivity().onBackPressed();
            }
        });


        return rootView;
    }
}
