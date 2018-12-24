package com.example.ronig.myapplication.Objects;

public class Computer_Object {

    public Case_Object case_name;
    public CPU_Object cpu_name;
    public GPU_Object gpu_name;
    public Memory_Object memory_name;
    public MotherBoard_Object motherboard_name;
    public SSD_Object ssd_name;

    public Computer_Object()
    {
        this.cpu_name=new CPU_Object();
        this.case_name=new Case_Object();
        this.gpu_name=new GPU_Object();
        this.memory_name=new Memory_Object();
        this.motherboard_name=new MotherBoard_Object();
        this.ssd_name=new SSD_Object();

    }
   public Computer_Object(CPU_Object cpu_name, MotherBoard_Object motherBoard_name, Memory_Object memory_name
    ,SSD_Object ssd_name, GPU_Object gpu_name, Case_Object case_name) {
        this.cpu_name = cpu_name;
        this.motherboard_name = motherBoard_name;
        this.memory_name = memory_name;
        this.ssd_name = ssd_name;
        this.gpu_name = gpu_name;
        this.case_name = case_name;
    }


}
