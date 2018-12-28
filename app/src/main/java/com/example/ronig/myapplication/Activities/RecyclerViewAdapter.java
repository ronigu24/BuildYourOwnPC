package com.example.ronig.myapplication.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, ArrayList<String> usersOrders1) {

        usersOrders = usersOrders1;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = mInflater.from(parent.getContext()).inflate(R.layout.layout_orders, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.userOrder.setText(usersOrders.get(position));

    }

    @Override
    public int getItemCount() {
        return usersOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userOrder;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            userOrder = itemView.findViewById(R.id.userOrder);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }

    }
}
