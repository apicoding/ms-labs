import React, {Component} from "react";
import {Link} from "react-router";

export default class Navigation extends Component {
    render() {
        return (
            <div>
                <Link to='/'>Home</Link>&nbsp;
                <Link to='/search'>Recherche</Link>&nbsp;&nbsp;
                <Link to='/admin'>Administration</Link>&nbsp;&nbsp;
                <a href="/login"> Se connecter123</a>
            </div>
        )
    }
}
