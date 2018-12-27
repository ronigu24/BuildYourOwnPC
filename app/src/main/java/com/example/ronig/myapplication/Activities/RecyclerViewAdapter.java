package com.example.ronig.myapplication.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ronig.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> usersOrders = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> usersOrders) {
        this.usersOrders = usersOrders;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_orders, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.userName.setText(usersOrders.get(position));

    }

    @Override
    public int getItemCount() {
        return usersOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            userName = itemView.findViewById(R.id.userOrder);


        }

    }
}
