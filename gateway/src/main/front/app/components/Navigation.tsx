import * as React from "react";
import {Link} from "react-router";
import UserContext from "../data/UserContext";
// import styles from "../styles/style.scss";
import client from "../api/client";

export interface NavigationState { isAuthenticated: boolean, user: UserContext
}

export interface IMainProps {}

export default class Navigation extends React.Component<IMainProps, NavigationState> {

    state: NavigationState = { isAuthenticated : false, user : undefined };

    constructor(props, context) {
        super(props, context);
    };

    componentWillMount() {
        client({
            method: 'GET',
            path: '/api/user',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(response => {
            if (response.entity !== "") {
                this.setState({
                    isAuthenticated : true,
                    user : response.entity
                });
            }
        }, response => {
            if (response.status.code === 403) {
                alert('ACCESS DENIED: You are not authorized to update ');
            }
            if (response.status.code === 412) {
                alert('DENIED: Unable to update ');
            }
            if (response.status.code === 302) {
                alert('DENIED: Redirection ');
                window.location.href = response.headers.location;
            }
        });
    }

    render() {
        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                { this.state.user.hasAuthority("ROLE_ADMIN") ? <Link to='/search'>Recherche</Link> : '' }&nbsp;&nbsp;
                { this.state.user.hasAuthority("ROLE_ADMIN") ? <Link to='/admin'>Administration</Link> : '' }&nbsp;&nbsp;
                { this.state.isAuthenticated == false ? <a href="/login">Connexion</a> :
                    <a href="/logout">({this.state.user.login})&nbsp;Déconnexion</a> }
            </div>
        )
    }
}
