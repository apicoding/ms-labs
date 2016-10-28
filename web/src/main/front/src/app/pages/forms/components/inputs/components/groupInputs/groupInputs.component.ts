import {Component} from "@angular/core";
import {User} from "../../../../../../model/User";
import {UserApi} from "../../../../../../api/UserApi";

@Component({
  selector: 'group-inputs',
  template: require('./groupInputs.html'),
})
export class GroupInputs {

  users: User[];

  constructor(private userService: UserApi) {
  }

  clicked(event) {
    alert('eeee');
    this.userService.findAll();
  }
}
