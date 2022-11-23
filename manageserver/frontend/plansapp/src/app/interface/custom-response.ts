import { Plan } from "./plan";

export interface CustomResponse{
 timestamp:Date;
 statusCode:number;
 status:string;
 reason:string;
 message:string;
 developerMessage:string;
 data:{plans?:Plan[],plan?:Plan};

}