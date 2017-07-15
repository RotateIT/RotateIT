import {Component} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {

  users: string[];

  constructor(http: Http) {

    http.get('api/anyDataFromDb')
      .map(res => res.json())
      .subscribe(
        users => this.users = users,
        err => console.log(err)
      );
  }
}
