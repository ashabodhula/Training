
import { Status } from "../enum/status.enum";
import { Type } from "../enum/type.enum";
export interface Plan{
    id:number;
    ipAddress:string;
    name:string;
    planDetails:string;
    price:number;
    type:Type;
    imageurl:string;
    status:Status;


}