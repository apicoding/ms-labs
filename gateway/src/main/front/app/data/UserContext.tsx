/**
 * Created by t0135150 on 01/03/2017.
 */
export default class UserContext {

    login : string;

    authenticated : boolean = false;

    authorities: string[];

    constructor(login = "anonymous", authenticated = false, authorities = []) {
        this.login = login;
        this.authenticated = authenticated;
        this.authorities = authorities;
    }

    hasAuthority(authority : string) {
        if (this.authorities != undefined) {
            return Array.from(this.authorities).indexOf(authority) > -1;
        }
        return false;
    };
}
