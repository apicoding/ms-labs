/**
 * Created by t0135150 on 01/03/2017.
 */
export default class UserContext {

    login: string;

    authenticated: boolean = false;

    authorities: string[];

    constructor(json: any = null) {
        if(json != null){
            for (var propName in json) {
                this[propName] = json[propName]
            }
        }
    }

    public hasAuthority(authority: string): boolean {
        if (this.authorities != undefined && this.authorities.length > 0) {
            return this.authorities.indexOf(authority) > -1;
        }
        return false;
    };
}
