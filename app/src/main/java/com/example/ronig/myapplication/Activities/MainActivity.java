package com.example.ronig.myapplication.Activities;

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
import com.example.ronig.myapplication.Objects.CPU_Object;
import com.example.ronig.myapplication.Objects.Case_Object;
import com.example.ronig.myapplication.Objects.Computer_Object;
import com.example.ronig.myapplication.Objects.GPU_Object;
import com.example.ronig.myapplication.Objects.Memory_Object;
import com.example.ronig.myapplication.Objects.MotherBoard_Object;
import com.example.ronig.myapplication.Objects.SSD_Object;
import com.example.ronig.myapplication.Objects.User;
import com.example.ronig.myapplication.R;
import com.example.ronig.myapplication.SSD.SSD_Main_Tab;

public class MainActivity extends AppCompatActivity {

  private   Button buybutt;
  private  Button cpubutt;
  private  Button motherbutt;
  private Button memorybutt;
  private Button ssdbutt;
  private Button casebutt;
  private Button gpubutt;

  public static User current_user;
  public static CPU_Object user_cpu;
  public static GPU_Object user_gpu;
  public static Memory_Object user_ram;
  public static SSD_Object user_ssd;
  public static MotherBoard_Object user_motherboard;
  public static Case_Object user_case;
  public static Computer_Object user_pc;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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
                    user_pc = new Computer_Object(user_cpu, user_motherboard, user_ram, user_ssd, user_gpu, user_case);
                    current_user.build_pc(user_pc);


                    Intent i = new Intent(getApplicationContext(), Purchase.class);
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

