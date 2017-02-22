import React, { Component } from 'react'
import { Router, Route, Link, IndexRoute, hashHistory, browserHistory } from 'react-router'
import Address from './components/Address';
import Home from './components/Home';
import NotFound from './components/NotFound';

const Nav = () => (
    <div>
        <Link to='/'>Home</Link>&nbsp;
        <Link to='/address'>Address</Link>
    </div>
)

const Container = (props) => <div>
    <Nav />
    {props.children}
</div>

class App extends Component {
    render() {
        return (
            <Router history={hashHistory}>
                <Route path='/' component={Container}>
                    <IndexRoute component={Home} />
                    <Route path='/address' component={Address} />
                    <Route path='*' component={NotFound} />
                </Route>
            </Router>
        )
    }
}

export default App