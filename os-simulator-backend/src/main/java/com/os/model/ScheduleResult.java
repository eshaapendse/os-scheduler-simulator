package com.os.model;

public class ScheduleResult {

    private String processName;
    private int start;
    private int completion;
    private int waiting;
    private int turnaround;

    public ScheduleResult() {}

    public ScheduleResult(String processName, int start, int completion, int waiting, int turnaround) {
        this.processName = processName;
        this.start = start;
        this.completion = completion;
        this.waiting = waiting;
        this.turnaround = turnaround;
    }

    public String getProcessName() { return processName; }
    public void setProcessName(String processName) { this.processName = processName; }

    public int getStart() { return start; }
    public void setStart(int start) { this.start = start; }

    public int getCompletion() { return completion; }
    public void setCompletion(int completion) { this.completion = completion; }

    public int getWaiting() { return waiting; }
    public void setWaiting(int waiting) { this.waiting = waiting; }

    public int getTurnaround() { return turnaround; }
    public void setTurnaround(int turnaround) { this.turnaround = turnaround; }
}