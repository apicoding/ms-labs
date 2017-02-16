'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./api/client')
// end::vars[]

// tag::app[]
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {employees: "Aucun appel au service effectué pour le moment"};

        // Handle
        this.callAdminService = this.callAdminService.bind(this);
        this.callUserService = this.callUserService.bind(this);
        this.logout = this.logout.bind(this);
    }


    callAdminService() {
        client({method: 'GET', path: '/admin-profile'}).done(response => {
            this.setState({employees: response.entity.firstname});
            console.log(response);
        }, response => {
            if (response.status.code === 403) {
                alert('ACCESS DENIED: You are not authorized to update ');
            }
            if (response.status.code === 412) {
                alert('DENIED: Unable to update. Your copy is stale.');
            }
        });
    }

    callUserService() {
        client({method: 'GET', path: '/user-profile'}).done(response => {
            this.setState({employees: response.entity.firstname});
            console.log(response);
        }, response => {
            if (response.status.code === 403) {
                alert('ACCESS DENIED: You are not authorized to update ');
            }
            if (response.status.code === 412) {
                alert('DENIED: Unable to update. Your copy is stale.');
            }
        });
    }

    logout() {
        client({method: 'GET', path: '/logout'}).done(response => {
            document.location.href = './'
        }, response => {
            if (response.status.code === 403) {
                alert('ACCESS DENIED: You are not authorized to update ');
            }
            if (response.status.code === 412) {
                alert('DENIED: Unable to update. Your copy is stale.');
            }
        });
    }

    render() {
        return (
            <div>
                <form action="/logout" method="POST">
                    {this.state.employees}
                    <br />
                    <br />
                    <button type="button" onClick={this.callAdminService}>Service Admin</button>
                    <br />
                    <br />
                    <button type="button" onClick={this.callUserService}>Service User</button>
                    <br />
                    <br />
                    <button type="submit">Deconnexion</button>
                </form>
            </div>
        )
    }
}
// end::app[]


// tag::render[]
ReactDOM.render(
    <App />,
    document.getElementById('react')
)
// end::render[]