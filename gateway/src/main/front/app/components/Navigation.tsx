import * as React from "react";
import {Link} from "react-router";
import UserContext from "../data/UserContext";
// import styles from "../styles/style.scss";
import HttpUtil from "../api/HttpUtil";

export interface NavigationState {
    user: UserContext
}

export interface NavigationProps {
}

export default class Navigation extends React.Component<NavigationProps, NavigationState> {


    constructor(props: NavigationProps) {
        super(props);
        this.state = {user: new UserContext()}
    };


    componentDidMount() {
        HttpUtil.get("/api/user")
            .subscribe(
                (data: any) => {
                    this.setState({user: new UserContext(data)});
                },
                (error) => {
                    console.error(error)
                }
            );
    }

    render() {
        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                { this.state.user.hasAuthority('ROLE_ADMIN') ? <Link to='/search'>Recherche</Link> : '' }&nbsp;&nbsp;
                { this.state.user.hasAuthority('ROLE_ADMIN') ? <Link to='/admin'>Administration</Link> : '' }&nbsp;&nbsp;
                { this.state.user.authenticated ?  <a href="/logout">({this.state.user.login})&nbsp;Déconnexion</a> :
                    <a href="/login">Connexion</a> }
            </div>
        )
    }
}
