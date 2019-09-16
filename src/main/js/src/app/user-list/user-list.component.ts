import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { Process } from '../model/process';
import { UserService } from '../service/user.service';
import { ProcessService } from '../service/process.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];
  processes: Process[];

  constructor(private userService: UserService, private processService: ProcessService) {

  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
    this.processService.listAll().subscribe(processdata => {
          this.processes = processdata;
    });
  }

  startProcess(){
      console.log("function starte Prozess called");
      this.processService.startProcess().subscribe(process => console.log("Process = " + process.id + " businesskey = " + process.businesskey));
    }
}
