import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL ="http://localhost:8082/api/auth/signup"
@Injectable({//decorator
  providedIn: 'root'
})
export class UserService {///age/{age}/height/{height}
  save(user: any) {
    return this.http.post(URL,user);
  }

  constructor(public http:HttpClient) { }

}
