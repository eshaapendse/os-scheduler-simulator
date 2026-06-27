import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SchedulerService } from '../../core/scheduler/scheduler.service';
import { ScheduleRequest } from '../../models/schedule-request';
import { ScheduleResult } from '../../models/schedule-result';

@Component({
  selector: 'app-scheduler',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './scheduler.html',
  styleUrl: './scheduler.css'
})
export class Scheduler {

  private service = inject(SchedulerService);

  // -----------------------------
  // INPUT SIGNALS
  // -----------------------------

  algorithm = signal('FCFS');

  arrival = signal('');

  burst = signal('');

  priority = signal('');

  quantum = signal(2);

  // -----------------------------
  // OUTPUT SIGNALS
  // -----------------------------

  results = signal<ScheduleResult[]>([]);

  loading = signal(false);

  averageWaiting = signal(0);

  averageTurnaround = signal(0);

  cpuUtilization = signal(0);

  throughput = signal(0);

  error = signal('');

  // -----------------------------
  // SOLVE
  // -----------------------------

  solve(): void {

    this.error.set('');

    const arrival = this.arrival()
      .trim()
      .split(/\s+/)
      .filter(x => x.length > 0)
      .map(Number);

    const burst = this.burst()
      .trim()
      .split(/\s+/)
      .filter(x => x.length > 0)
      .map(Number);

    const priority = this.priority()
      .trim()
      .split(/\s+/)
      .filter(x => x.length > 0)
      .map(Number);

    if (arrival.length !== burst.length) {

      this.error.set(
        'Arrival Times and Burst Times must have the same number of values.'
      );

      return;

    }

    if (this.algorithm() === 'PRIORITY' &&
        priority.length !== arrival.length) {

      this.error.set(
        'Priority values must match the number of processes.'
      );

      return;

    }

    const request: ScheduleRequest = {

      algorithm: this.algorithm(),

      arrivalTimes: arrival,

      burstTimes: burst,

      priorities: priority,

      quantum: this.quantum()

    };

    this.loading.set(true);

    this.service.run(request).subscribe({

      next: (data) => {

        this.results.set(data);

        this.calculateMetrics(data, burst);

        this.loading.set(false);

      },

      error: (err) => {

        console.error(err);

        this.error.set('Unable to connect to Spring Boot backend.');

        this.loading.set(false);

      }

    });

  }

  // -----------------------------
  // RESET
  // -----------------------------

  reset(): void {

    this.algorithm.set('FCFS');

    this.arrival.set('');

    this.burst.set('');

    this.priority.set('');

    this.quantum.set(2);

    this.results.set([]);

    this.averageWaiting.set(0);

    this.averageTurnaround.set(0);

    this.cpuUtilization.set(0);

    this.throughput.set(0);

    this.error.set('');

  }

  // -----------------------------
  // METRICS
  // -----------------------------

  private calculateMetrics(
    data: ScheduleResult[],
    burst: number[]
  ): void {

    if (data.length === 0) return;

    const totalWaiting =
      data.reduce((sum, p) => sum + p.waiting, 0);

    const totalTurnaround =
      data.reduce((sum, p) => sum + p.turnaround, 0);

    const totalBurst =
      burst.reduce((a, b) => a + b, 0);

    const finish =
      Math.max(...data.map(x => x.completion));

    this.averageWaiting.set(
      totalWaiting / data.length
    );

    this.averageTurnaround.set(
      totalTurnaround / data.length
    );

    this.cpuUtilization.set(
      (totalBurst / finish) * 100
    );

    this.throughput.set(
      data.length / finish
    );

  }

}