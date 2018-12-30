package com.example.ronig.myapplication.Activities;


import android.Manifest;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.example.ronig.myapplication.CPU.CPU_Main_Tab;
import com.example.ronig.myapplication.Case.Case_Main_Tab;
import com.example.ronig.myapplication.GPU.GPU_Main_Tab;
import com.example.ronig.myapplication.Memory.Memory_Main_Tab;
import com.example.ronig.myapplication.MotherBoard.MotherBoard_Main_Tab;
import com.example.ronig.myapplication.Objects.Products.CPU;
import com.example.ronig.myapplication.Objects.Products.Case;
import com.example.ronig.myapplication.Objects.Products.Computer;
import com.example.ronig.myapplication.Objects.Products.GPU;
import com.example.ronig.myapplication.Objects.Products.RAM;
import com.example.ronig.myapplication.Objects.Products.MotherBoard;
import com.example.ronig.myapplication.Objects.Products.SSD;
import com.example.ronig.myapplication.Objects.User;
import com.example.ronig.myapplication.R;
import com.example.ronig.myapplication.SSD.SSD_Main_Tab;

public class MainActivity extends AppCompatActivity {

  private Button buybutt;
  private Button cpubutt;
  private Button motherbutt;
  private Button memorybutt;
  private Button ssdbutt;
  private Button casebutt;
  private Button gpubutt;

  public static User current_user;
  public static CPU user_cpu;
  public static GPU user_gpu;
  public static RAM user_ram;
  public static SSD user_ssd;
  public static MotherBoard user_motherboard;
  public static Case user_case;

  public static Computer user_pc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},00);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.current_user.my_pc.totalprice=="") {
                    Snackbar.make(view, "Order Cart is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else
                {
                    Intent i = new Intent(getApplicationContext(), MyOrdersActivity.class);
                    startActivity(i);
                }
            }
        });

        buybutt =(Button)findViewById(R.id.buy);
        buybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_gpu==null)
                { Toast.makeText(getApplication(),"Gpu is missing",Toast.LENGTH_SHORT).show(); }
                else if(user_cpu==null)
                { Toast.makeText(getApplication(),"Cpu is missing",Toast.LENGTH_SHORT).show(); }
                else if(user_ram==null)
                { Toast.makeText(getApplication(),"Ram is missing",Toast.LENGTH_SHORT).show(); }
                else if(user_motherboard==null)
                { Toast.makeText(getApplication(),"MotherBoard is missing",Toast.LENGTH_SHORT).show(); }
                else if(user_ssd==null)
                { Toast.makeText(getApplication(),"Ssd is missing",Toast.LENGTH_SHORT).show(); }
                else if(user_case==null)
                { Toast.makeText(getApplication(),"Case is missing",Toast.LENGTH_SHORT).show(); }
                else {

                    user_pc = new Computer(user_cpu, user_motherboard, user_ram, user_ssd, user_gpu, user_case);
                    current_user.build_pc(user_pc);


                    Intent i = new Intent(getApplicationContext(), PurchaseActivity.class);
                    startActivity(i);

                }
            }



        });

        cpubutt =(Button)findViewById(R.id.cpu);
        cpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CPU_Main_Tab.class);
                startActivity(i);
            }
        });

        motherbutt =(Button)findViewById(R.id.motherBoard);
        motherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MotherBoard_Main_Tab.class);
                startActivity(i);

            }
        });

        memorybutt =(Button)findViewById(R.id.memory);
        memorybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Memory_Main_Tab.class);
                startActivity(i);

            }



        });

        ssdbutt =(Button)findViewById(R.id.ssd);
        ssdbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SSD_Main_Tab.class);
                startActivity(i);

            }
        });
        casebutt =(Button)findViewById(R.id.case1);
        casebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Case_Main_Tab.class);
                startActivity(i);
            }
        });

        gpubutt =(Button)findViewById(R.id.gpu);
        gpubutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GPU_Main_Tab.class);
                startActivity(i);

            }
        });


    }
}

