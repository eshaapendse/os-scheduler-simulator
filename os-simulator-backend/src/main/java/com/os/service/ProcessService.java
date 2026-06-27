package com.os.service;

import com.os.model.Process;
import com.os.model.ProcessState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProcessService {

    private final List<Process> processList = new ArrayList<>();
    private final AtomicInteger pidCounter = new AtomicInteger(1);

    public Process createProcess(String name, int burstTime) {
        Process process = new Process(
                pidCounter.getAndIncrement(),
                name,
                ProcessState.READY,
                burstTime
        );

        processList.add(process);
        return process;
    }

    public List<Process> getAllProcesses() {
        return processList;
    }
}