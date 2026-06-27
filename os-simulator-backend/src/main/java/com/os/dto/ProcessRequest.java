package com.os.dto;

public class ProcessRequest {

    private String name;
    private int burstTime;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getBurstTime() { return burstTime; }
    public void setBurstTime(int burstTime) { this.burstTime = burstTime; }
}