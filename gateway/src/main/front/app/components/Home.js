import React, {Component} from "react";
import { connect } from 'react-redux';
import {Field,Form, actions} from "react-redux-form";

var client = require('../api/client');

class Home extends Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            userDto: {
                firstname: '',
                lastname: '',
                currentDate: ''
            }
        };

        this.createUser = this.createUser.bind(this);
    };

    componentDidMount() {
        client({
            method: 'GET',
            path: '/api/employees'
        }).then(response => {
            this.setState({userDto: response.entity});
        });
    }


    createUser(user) {
        let { dispatch } = this.props;
        // Do whatever you like in here.
        // You can use actions such as:
        // dispatch(actions.submit('user', somePromise));
        // etc.
        console.log(user);
        client({
            method: 'POST',
            path: '/api/create',
            entity: user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            this.setState({userDto: response.entity });
        });
    }

    render() {
        return (
            <div>
                <h1>Container Home</h1>
                <h2>Date serveur : {this.state.userDto.currentDate}</h2>
                <h2>Firstname : {this.state.userDto.firstname}</h2>
                <h2>Lastname : {this.state.userDto.lastname}</h2>
                <h1>------------------------------------------------</h1>
                <Form  model="user" onSubmit={(user) => this.createUser(user)}>
                    <Field model="user.firstname">
                        <label>Username</label>
                        <input type="text"/>
                    </Field>
                    <Field model="user.lastname">
                        <label>Lastname</label>
                        <input type="text"/>
                    </Field>

                    <button>Create</button>
                </Form>
            </div>
        )
    }
}

const selector = (state) => ({user: state.user});
export default connect(selector)(Home);