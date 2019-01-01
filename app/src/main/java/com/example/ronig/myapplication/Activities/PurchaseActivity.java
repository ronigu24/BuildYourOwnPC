package com.example.ronig.myapplication.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PurchaseActivity extends AppCompatActivity {


    public static DataBaseHelper db;

    private NotificationCompat.Builder mBuilder;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        createNotificationChannel();
        notificationManager = NotificationManagerCompat.from(this);

        mBuilder = new NotificationCompat.Builder(this, "MyChannel")
                .setContentTitle("Title")
                .setContentText("Content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        db = new DataBaseHelper(this);
        Button pay_Btn = (Button) findViewById(R.id.pay);
        TextView pay_Cpu_TextView = (TextView) findViewById(R.id.paytext_cpu);
        TextView pay_Motherboard_TextView = (TextView) findViewById(R.id.paytext_motherboard);
        TextView pay_Memory_TextView = (TextView) findViewById(R.id.paytext_memory);
        TextView pay_SSD_TextView = (TextView) findViewById(R.id.paytext_ssd);
        TextView pay_Gpu_TextView = (TextView) findViewById(R.id.paytext_gpu);
        TextView pay_Case_TextView = (TextView) findViewById(R.id.paytext_case);
        TextView Price_TextView = (TextView) findViewById(R.id.Price);

        setPayText(pay_Cpu_TextView, MainActivity.user_cpu.print());
        setPayText(pay_Motherboard_TextView, MainActivity.user_motherboard.print());
        setPayText(pay_Memory_TextView, MainActivity.user_ram.print());
        setPayText(pay_SSD_TextView, MainActivity.user_ssd.print());
        setPayText(pay_Gpu_TextView, MainActivity.user_gpu.print());
        setPayText(pay_Case_TextView, MainActivity.user_case.print() );
        setPayText(Price_TextView, MainActivity.user_pc.printsum());

        FloatingActionButton fab = findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
                Snackbar.make(view, "Print screen was taken", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        pay_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.addOrder();

                Log.d("TAG", "Notification run");
                mBuilder.setContentText("Thank you for your purchase, Your order is pending for approval");
                mBuilder.setContentTitle("BuildYourOwnPC");
                mBuilder.setSmallIcon(R.drawable.order);
                notificationManager.notify(1, mBuilder.build());

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });



    }

    public void setPayText(TextView textView,String print){
        textView.setText(print);
    }

    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }


    public void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.notification_channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            String cid = getString(R.string.channel_id);
            NotificationChannel channel = new NotificationChannel(cid, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}

