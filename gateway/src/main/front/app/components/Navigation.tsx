import * as React from "react";
import {Link} from "react-router";
import HttpUtil from "../api/HttpUtil";
import UserContext from "../data/UserContext";
// import styles from "../styles/style.scss";

export interface NavigationState {
    user: UserContext
}

export interface NavigationProps {
}

export default class Navigation extends React.Component<NavigationProps, NavigationState> {

    constructor(props: NavigationProps) {
        super(props);
        var userContext = new UserContext();
        this.state = { user: userContext }
        this.hasAuthority = this.hasAuthority.bind(this);
    };


    componentDidMount() {
       HttpUtil.getHttp("/api/user").subscribe((userDTO: UserContext) => {
            this.setState({user: userDTO});
        });
    }

    hasAuthority(authority) {
        if (this.state.user != undefined) {
            return Array.from(this.state.user.authorities).indexOf(authority) > -1;
        }
        return false;
    };


    render() {
        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                { this.hasAuthority('ROLE_ADMIN') ? <Link to='/search'>Recherche</Link> : '' }&nbsp;&nbsp;
                { this.hasAuthority('ROLE_ADMIN') ? <Link to='/admin'>Administration</Link> : '' }&nbsp;&nbsp;
                { this.state.user.authenticated ?  <a href="/logout">({this.state.user.login})&nbsp;Déconnexion</a> : <a href="/login">Connexion</a> }
            </div>
        )
    }
}
