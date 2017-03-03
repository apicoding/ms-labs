import * as React from "react";
import {connect} from "react-redux";
import {Field, Form} from "react-redux-form";
import UserContext from "../data/UserContext";
import ReactDataGrid from "react-data-grid";
import client from "../api/client";

interface SearchState {
    columns: [{name: 'id', key: 'id', resizable: true, width: 40},
        {name: 'firstname', key: 'firstname'},
        {name: 'lastname', key: 'lastname'}],
    documents: [{id: '', firstname: '', lastname: ''}],
    userDto: UserContext

}
;

export class Search extends React.Component<{}, SearchState> {

    state: SearchState;

    constructor(props, context) {
        super(props, context);

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
                {this.state.documents.length > 0 ?
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