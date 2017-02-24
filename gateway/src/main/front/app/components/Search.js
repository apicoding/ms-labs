import React, {Component} from "react";
import {connect} from "react-redux";
import {Field, Form} from "react-redux-form";

var client = require('../api/client');
class Search extends Component {


    createUser(user) {
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
        return (<div>
                <h1>Recherche de document</h1>
                <Form model="user" onSubmit={(user) => this.createUser(user)}>
                    <Field model="user.firstname">
                        <label>Firstname</label>
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
export default connect(selector)(Search);