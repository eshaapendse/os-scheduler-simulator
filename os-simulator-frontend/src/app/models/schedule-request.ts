export interface ScheduleRequest {

  algorithm: string;

  arrivalTimes: number[];

  burstTimes: number[];

  priorities: number[];

  quantum: number;

}