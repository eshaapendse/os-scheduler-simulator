import { Component } from '@angular/core';
import { Scheduler } from './features/scheduler/scheduler';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Scheduler],
  template: `<app-scheduler></app-scheduler>`
})
export class App {}