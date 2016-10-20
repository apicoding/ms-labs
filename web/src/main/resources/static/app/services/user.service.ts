import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {User} from "./../model/user";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";

@Injectable()
export class UserService {

    constructor(private http: Http) {
    }

    private _serviceUrl = '/user/findAll';  // URL to web api

    findAll() {
        return this.http.get(this._serviceUrl)
            .map(res => <User[]> res.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        // in a real world app, we may send the error to some remote logging infrastructure
        // instead of just logging it to the console
        console.log(error);
        return Observable.throw(error.json().error || 'Server error');
    }
}