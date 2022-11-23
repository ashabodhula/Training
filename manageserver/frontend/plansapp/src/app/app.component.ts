import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, startWith } from 'rxjs/operators';
import { DataState } from './enum/data-state.enum';
import { AppState } from './interface/app-state';
import { CustomResponse } from './interface/custom-response';
import { PlanService } from './service/plan.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'plansapp';
  appState$:Observable<AppState<CustomResponse>>;
  
  constructor(private planService:PlanService){  }

  ngOnInit():void{
    this.appState$ = this.planService.plans$
    .pipe(
      map(response =>{
        return { dataState: DataState.LOADED_STATE , appData:response }
      }),
      startWith({dataState: DataState.LOADING_STATE }),
      catchError((error:string)=>{
        return of({dataState: DataState.ERROR_STATE,error})
      })
    );
  }
    


}
