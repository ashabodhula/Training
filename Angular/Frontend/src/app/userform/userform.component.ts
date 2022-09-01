import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
  user = {
    name: 'asha',
    age: 10,
    address: 'india'
  }
  users: any[] = [];

  constructor(public userService: UserService) { }

  saveUser() {
    console.log('clicked');
    const promise = this.userService.save(this.user);
    promise.subscribe((responseBody: any) => {
      console.log(responseBody);
      this.users.push(responseBody);
    },
      (error: any) => {
        console.log(error);
      }
    );

  }
  ngOnInit(): void {
  }

}
