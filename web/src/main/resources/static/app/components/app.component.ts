import {Component, OnInit} from "@angular/core";
import {HttpModule} from "@angular/http";
import {UserService} from "../services/user.service";
import {User} from "../model/user";


@Component({
    selector: 'my-app',
    template: `
      <h1>{{title}}</h1>
      <h2>Liste des utilisateurs</h2>
      <ul>
          <li *ngFor="let user of users">
              {{user.id}} : {{user.firstname}} {{user.lastname}}
         </li>
      </ul>
    `,
    providers: [HttpModule, UserService]
})


export class AppComponent implements OnInit {

    constructor(private userService: UserService) {
    }

    errorMessage: string;
    users: User[];
    public title = 'Administration';

    findAll() {
        this.userService.findAll().subscribe(
            users => this.users = users,
            error => this.errorMessage = <any>error);
    }

    ngOnInit() {
        this.findAll();
    }

} // export -> create a module