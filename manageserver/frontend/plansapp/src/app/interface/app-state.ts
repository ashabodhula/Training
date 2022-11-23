import { DataState } from "../enum/data-state.enum";

export interface AppState <T>{
    dataState:DataState; //to determine in what state the app is
    appData?: T;   //when the value of particular is optional we place ?
    error?:string;
}