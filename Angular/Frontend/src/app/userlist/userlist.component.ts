import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
  users: any[] = [];

  constructor(public userService: UserService) { }

  ngOnInit(): void {
    const observable = this.userService.getUsers();
    observable.subscribe((usersFromServer: any) => {
      this.users = usersFromServer;
    })
  }


}
