import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { ScheduleRequest } from '../../models/schedule-request';
import { ScheduleResult } from '../../models/schedule-result';

@Injectable({
  providedIn: 'root'
})
export class SchedulerService {

  private http = inject(HttpClient);

  private url = 'http://localhost:8081/api/schedule/run';

  run(request: ScheduleRequest): Observable<ScheduleResult[]> {

    return this.http.post<ScheduleResult[]>(this.url, request);

  }

}