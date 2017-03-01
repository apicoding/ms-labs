/**
 * Created by t0135150 on 01/03/2017.
 */
import React, {Component} from "react";
var client = require('../api/client');

export default class LoginButton extends Component {


    constructor(props, context) {
        super(props, context);
        this.state = {isAuthenticated : false, user : undefined}
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
            console.log(response);
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
                console.log(response);
                alert('DENIED: Redirection ');
                window.location.href = response.headers.location;            }
        });
    }

    render() {
        return (
            <div>
                { this.state.isAuthenticated == false ? <a href="/login">Se connecter</a> : <a href="/logout">Connecté {this.state.user.login}</a> }
            </div>
        )
    }
}