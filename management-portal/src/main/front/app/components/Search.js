import React, {Component, PropTypes} from "react";
import {connect} from "react-redux";
import {Field, Form} from "react-redux-form";

var ReactDataGrid = require('react-data-grid');
var client = require('../api/client');

class Search extends Component {

    constructor(props, context) {
        super(props, context);
        // State
        this.state = {
            columns: [{name: 'id', key: 'id', resizable: true, width: 40 },
                {name: 'firstname', key: 'firstname'},
                {name: 'lastname', key: 'lastname'}],
            documents: [{id: '', firstname: '', lastname: ''}]
        };

        this.rowGetter = this.rowGetter.bind(this);
    }


    componentWillMount() {
        client({
            method: 'GET',
            path: '/api/document/findall',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            this.setState({documents: response.entity});
        });
    }

    createUser(user) {
        client({
            method: 'POST',
            path: '/api/create',
            entity: user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            this.setState({userDto: response.entity});
        });
    }


    rowGetter(i) {
        return this.state.documents[i];
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
                <br/>
                {this.state.documents.length > 0  ?
                <ReactDataGrid
                    columns={this.state.columns}
                    rowGetter={this.rowGetter}
                    rowsCount={this.state.documents.length}/> : <div></div> }

            </div>
        )
    }


}

const selector = (state) => ({user: state.user});
export default connect(selector)(Search);