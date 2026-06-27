package com.os.model;

public class Process {

    private int pid;
    private String name;

    private ProcessState state;

    private int burstTime;
    private int remainingTime;

    private long arrivalTime;
    private long startTime;
    private long endTime;

    // 📊 METRICS
    private long turnaroundTime;
    private long waitingTime;
    private long responseTime;

    public Process() {}

    public Process(int pid, String name, ProcessState state, int burstTime) {
        this.pid = pid;
        this.name = name;
        this.state = state;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    // ---------------- BASIC GETTERS/SETTERS ----------------

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcessState getState() {
        return state;
    }

    public void setState(ProcessState state) {
        this.state = state;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    // ---------------- TIMING ----------------

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // ---------------- METRICS ----------------

    public long getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(long turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}