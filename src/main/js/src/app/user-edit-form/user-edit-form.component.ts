import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { User } from '../model/user';


@Component({
  selector: 'app-user-edit-form',
  templateUrl: './user-edit-form.component.html',
  styleUrls: ['./user-edit-form.component.css']
})
export class UserEditFormComponent implements OnInit {

  @Input() user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {

  }

   ngOnInit(): void {
      this.getUser();
    }

    getUser(): void {
      const id = +this.route.snapshot.paramMap.get('id');
      this.userService.getUser(id)
        .subscribe(user => this.user = user);
    }

  onSubmit() {
    this.userService.update(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
