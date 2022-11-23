import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL = "http://localhost:8082/user"
@Injectable({//decorator
  providedIn: 'root'
})
export class UserService {
  deleteUser(id: any) {
    return this.http.delete(URL+"/"+id);
  }
  save(user: any) {///age/{age}/height/{height}
    return this.http.post(URL + "/age/" + 34 + '/height/' + 100 + "?param1=43&param2", user);
  }

  getUsers() {
    return this.http.get(URL);
  }
  constructor(public http: HttpClient) { }
}
