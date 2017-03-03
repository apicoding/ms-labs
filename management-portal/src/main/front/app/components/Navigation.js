import React, {Component} from "react";
import {Link} from "react-router";
import UserContext from "../data/UserContext";

var client = require('../api/client');

export default class Navigation extends Component {


    constructor(props, context) {
        super(props, context);
        var userCtx = new UserContext('anonymous');
        this.state = {isAuthenticated : false, user : userCtx}
    };

    componentWillMount(){
        client({
            method: 'GET',
            path: '/api/user',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(response => {
            if(response.entity !== ""){
                this.setState({isAuthenticated: true, user : response.entity});
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
                window.location.href = response.headers.location;            }
        });
    }

    render() {

        var userCtx = new UserContext(this.state.user.login, this.state.user.authorities);
        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                { userCtx.hasAuthority("ROLE_ADMIN") ? <Link to='/search'>Recherche</Link> : '' }&nbsp;&nbsp;
                { userCtx.hasAuthority("ROLE_ADMIN") ? <Link to='/admin'>Administration</Link> : '' }&nbsp;&nbsp;
                { this.state.isAuthenticated == false ? <a href="/login">Connexion</a> :  <a href="/logout">({this.state.user.login})&nbsp;Déconnexion</a> }
            </div>
        )
    }
}
