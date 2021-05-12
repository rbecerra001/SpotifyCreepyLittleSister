import {UserService} from 'src/app/services/user/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public userName: string;
  public emailAddress: string;
  public password: string;

  registerUser(): void {
    const newUser = {username: this.userName, emailAddress: this.emailAddress, password: this.password};
    this.userService.registerUser(newUser)
    .subscribe(response => console.log(response),err => console.log(err));
  }

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }
}
