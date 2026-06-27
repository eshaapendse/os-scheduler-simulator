package com.os.model;

import java.util.List;

public class ScheduleResponse {

    private List<ScheduleResult> results;

    private List<GanttBlock> gantt;

    public ScheduleResponse() {
    }

    public ScheduleResponse(List<ScheduleResult> results,
                            List<GanttBlock> gantt) {
        this.results = results;
        this.gantt = gantt;
    }

    public List<ScheduleResult> getResults() {
        return results;
    }

    public void setResults(List<ScheduleResult> results) {
        this.results = results;
    }

    public List<GanttBlock> getGantt() {
        return gantt;
    }

    public void setGantt(List<GanttBlock> gantt) {
        this.gantt = gantt;
    }
}