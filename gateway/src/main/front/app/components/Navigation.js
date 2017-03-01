import React, {Component} from "react";
import {Link} from "react-router";
import LoginButton from './LoginButton';

export default class Navigation extends Component {

    render() {

        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                <Link to='/search'>Recherche</Link>&nbsp;&nbsp;
                <Link to='/admin'>Administration</Link>&nbsp;&nbsp;
                <LoginButton />
            </div>
        )
    }
}
