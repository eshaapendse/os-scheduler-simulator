package com.os.dto;

import java.util.List;

public class ScheduleRequest {

    private String algorithm;

    private List<Integer> arrivalTimes;

    private List<Integer> burstTimes;

    private List<Integer> priorities;

    private int quantum;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<Integer> getArrivalTimes() {
        return arrivalTimes;
    }

    public void setArrivalTimes(List<Integer> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    public List<Integer> getBurstTimes() {
        return burstTimes;
    }

    public void setBurstTimes(List<Integer> burstTimes) {
        this.burstTimes = burstTimes;
    }

    public List<Integer> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<Integer> priorities) {
        this.priorities = priorities;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }
}