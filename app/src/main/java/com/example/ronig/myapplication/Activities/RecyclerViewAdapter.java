package com.example.ronig.myapplication.Activities;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    DataBaseHelper db;

    private ArrayList<String> usersOrders = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> usersOrders1) {

        mContext = context;
        usersOrders = usersOrders1;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = mInflater.from(parent.getContext()).inflate(R.layout.layout_orders, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
static int stage=0;
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        db = new DataBaseHelper(mContext);

        holder.userOrder.setText(usersOrders.get(position));

        if (MainActivity.current_user.getName().equals("admin")) {
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch (stage) {
                        case (0):
                            Toast.makeText(mContext, "Approved", Toast.LENGTH_SHORT).show();
                            stage++;
                            db.changeStatus("Approved", position + 1);
                            break;
                        case (1):
                            Toast.makeText(mContext, "Canceled", Toast.LENGTH_SHORT).show();
                            stage--;
                            db.changeStatus("Canceled", position + 1);

                            break;
                    }




                }
            });


        }
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
