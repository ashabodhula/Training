import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { Status } from '../enum/status.enum';
import { CustomResponse } from '../interface/custom-response';
import { Plan } from '../interface/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
  
 private readonly apiUrl ='http://localhost:8081';
  constructor(private http:HttpClient) { }
//procedural approach
  // getPlan():Observable<CustomResponse>{
  //   return this.http.get<CustomResponse>('http://localhost:8085/plan/list');
  // }
//reactive approach

//while defining observables it is better to use $sybmbol
//below observable will get the list of plans
plans$ = <Observable <CustomResponse>>this.http.get<CustomResponse>(`${this.apiUrl}/plan/list`)
.pipe(
  tap(console.log),
  catchError(this.handleError)
);

//for saving the plan we have to send a plan as a request body i.e plan:Plan=>
save$ = (plan:Plan)=><Observable <CustomResponse>>this.http.post<CustomResponse>(`${this.apiUrl}/plan/save`,plan)
.pipe(
  tap(console.log),
  catchError(this.handleError)
);

ping$ = (ipAddress:string)=><Observable <CustomResponse>>this.http.get<CustomResponse>(`${this.apiUrl}/plan/ping,${ipAddress}`)
.pipe(
  tap(console.log),
  catchError(this.handleError)
);


delete$ = (planId:number)=><Observable <CustomResponse>>this.http.delete<CustomResponse>(`${this.apiUrl}/plan/delete,${planId}`)
.pipe(
  tap(console.log),
  catchError(this.handleError)
);

filter$ = (status:Status,response:CustomResponse)=><Observable <CustomResponse>>
new Observable<CustomResponse>(
  Subscriber=>{
    console.log(response);
    Subscriber.next(
      status===Status.ALL?{...response,message:`plans filtered by ${status} status`}:
      {
        
        ...response,
        message:response.data.plans 
        .filter(server =>server.status===status).length > 0 ? `Plans filtered by status
        ${status===Status.PLAN_ACTIVE?`PLAN ACTIVE`:`PLAN NOTACTIVE`} status`:`no plans of ${status }found`,
        data:{plans:response.data.plans 
          .filter(server =>server.status===status)}
      }
    );
   Subscriber.complete();
     
  }
)
.pipe(
  tap(console.log),
  catchError(this.handleError)
);
//we can setup developer message in case of errors
 private handleError(error:HttpErrorResponse):Observable <never> {
   console.log(error);
   return throwError(`an error occoured -Error code:${error.status}`);
}
}
