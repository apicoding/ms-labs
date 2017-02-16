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
        this.callAdminService = this.callAdminService.bind(this);
        this.callUserService = this.callUserService.bind(this);
    }

    /* componentDidMount() {
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
     }*/

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

    render() {
        return (
            <div>
                {this.state.employees}
                <br />
                <br />
                <button type="button" onClick={this.callAdminService}>Service Admin</button>
                <br />
                <br />
                <button type="button" onClick={this.callUserService}>Service User</button>
                <br />
                <br />
                <button type="button" formAction="/logout" formMethod="post">Deconnexion post</button>
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