package com.example.ronig.myapplication.Objects.Products;

import com.example.ronig.myapplication.Objects.Products.CPU;
import com.example.ronig.myapplication.Objects.Products.Case;
import com.example.ronig.myapplication.Objects.Products.GPU;
import com.example.ronig.myapplication.Objects.Products.MotherBoard;
import com.example.ronig.myapplication.Objects.Products.RAM;
import com.example.ronig.myapplication.Objects.Products.SSD;

public class Computer {

    public Case case_name;
    public CPU cpu_name;
    public GPU gpu_name;
    public RAM memory_name;
    public MotherBoard motherboard_name;
    public SSD ssd_name;
public String totalprice=" ";

    public Computer()
    {
        this.cpu_name=new CPU();
        this.case_name=new Case();
        this.gpu_name=new GPU();
        this.memory_name=new RAM();
        this.motherboard_name=new MotherBoard();
        this.ssd_name=new SSD();

    }
   public Computer(CPU cpu_name, MotherBoard motherBoard_name, RAM memory_name
    , SSD ssd_name, GPU gpu_name, Case case_name) {
        this.cpu_name = cpu_name;
        this.motherboard_name = motherBoard_name;
        this.memory_name = memory_name;
        this.ssd_name = ssd_name;
        this.gpu_name = gpu_name;
        this.case_name = case_name;
    }

    public String printsum(){
        int sum=0;
        sum+=Integer.parseInt(case_name.price.substring(0,case_name.price.length()-2).trim());
        sum+=Integer.parseInt(cpu_name.price.substring(0,cpu_name.price.length()-2).trim());
        sum+=Integer.parseInt(gpu_name.price.substring(0,gpu_name.price.length()-2).trim());
        sum+=Integer.parseInt(memory_name.price.substring(0,memory_name.price.length()-2).trim());
        sum+=Integer.parseInt(motherboard_name.price.substring(0,motherboard_name.price.length()-2).trim());
        sum+=Integer.parseInt(ssd_name.price.substring(0,ssd_name.price.length()-2).trim());

        this.totalprice=""+sum;

        return "Price: " + sum;
    }


}
