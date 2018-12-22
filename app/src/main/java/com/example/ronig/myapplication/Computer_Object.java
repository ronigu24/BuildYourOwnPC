package com.example.ronig.myapplication;

public class Computer_Object {

    Case_Object case_name;
    CPU_Object cpu_name;
    GPU_Object gpu_name;
    Memory_Object Memory_name;
    MotherBoard_Object MotherBoard_name;
    SSD_Object ssd_name;

    Computer_Object(CPU_Object cpu_name, MotherBoard_Object motherBoard_name, Memory_Object memory_name
    ,SSD_Object ssd_name, GPU_Object gpu_name, Case_Object case_name) {
        this.cpu_name = cpu_name;
        this.MotherBoard_name = motherBoard_name;
        this.Memory_name = memory_name;
        this.ssd_name = ssd_name;
        this.gpu_name = gpu_name;
        this.case_name = case_name;
    }


}
