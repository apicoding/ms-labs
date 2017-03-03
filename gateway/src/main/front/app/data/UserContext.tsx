/**
 * Created by t0135150 on 01/03/2017.
 */
export default class UserContext {

    login : string;

    authorities: string[];

    constructor(login, authorities) {
        this.login = login;
        this.authorities = authorities;
    }

    hasAuthority(authority) {
        if (this.authorities != undefined) {
            return Array.from(this.authorities).indexOf(authority) > -1;
        }
        return false
    };
}
