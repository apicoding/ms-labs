import * as React from 'react'
import Navigation from './Navigation'
import Footer from './Footer'

export default class Container extends React.Component<undefined, undefined> {
    render() {
        return (
            <div>
                <h1>Portail Clients</h1>
                <Navigation />
                <div>{this.props.children}</div>
                <Footer />
            </div>
        )
    }
}