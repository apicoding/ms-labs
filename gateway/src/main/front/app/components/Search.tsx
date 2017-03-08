import * as React from "react";
import {connect} from "react-redux";
import {Field, Form} from "react-redux-form";
import UserContext from "../data/UserContext";
import HttpUtil from "../api/HttpUtil";
import {Document} from "../data/Document";
import ReactDataGrid from 'react-data-grid';

export interface SearchState {
    columns: [{name: 'id', key: 'key'},
        {name: 'firstname', key: 'firstname'},
        {name: 'lastname', key: 'lastname'}],
    documents: Document[],
}
;

export class Search extends React.Component<{}, SearchState> {

    constructor(props, context) {
        super(props, context);

        this.state = {columns: [{name: 'id', key: 'key'},
            {name: 'firstname', key: 'firstname'},
            {name: 'lastname', key: 'lastname'}],
            documents: []};

        this.rowGetter = this.rowGetter.bind(this);
    }


    componentDidMount() {
        HttpUtil.get("/api/document/findall").subscribe((documentsDTO: Document[]) => {
            console.log(documentsDTO);
            this.setState({documents: documentsDTO});
        });
    }

    createUser(user) {
        HttpUtil.post("/api/create", user);
    }


    rowGetter(i) {
        return this.state.documents[i];
    }

    render() {
        console.log(this.state.documents);
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