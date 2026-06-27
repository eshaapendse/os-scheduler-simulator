package com.os.model;

public class SchedulerMetrics {

    private double avgWaitingTime;
    private double avgTurnaroundTime;
    private double avgResponseTime;
    private double cpuUtilization;

    public SchedulerMetrics() {}

    public double getAvgWaitingTime() {
        return avgWaitingTime;
    }

    public void setAvgWaitingTime(double avgWaitingTime) {
        this.avgWaitingTime = avgWaitingTime;
    }

    public double getAvgTurnaroundTime() {
        return avgTurnaroundTime;
    }

    public void setAvgTurnaroundTime(double avgTurnaroundTime) {
        this.avgTurnaroundTime = avgTurnaroundTime;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }

    public double getCpuUtilization() {
        return cpuUtilization;
    }

    public void setCpuUtilization(double cpuUtilization) {
        this.cpuUtilization = cpuUtilization;
    }
}