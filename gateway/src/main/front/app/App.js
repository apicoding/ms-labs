import React, {Component} from "react";
import {Router, Route, IndexRoute, hashHistory} from "react-router";
import Search from "./components/Search";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Container from "./components/Container";
import Administration from "./components/Administration";


class App extends Component {
    render() {
        return (
            <Router history={hashHistory}>
                <Route path='/' component={Container}>
                    <IndexRoute component={Home}/>
                    <Route path='/search' component={Search}/>
                    <Route path='/admin' component={Administration}/>
                    <Route path='*' component={NotFound}/>
                </Route>
            </Router>
        )
    }
}

export default App