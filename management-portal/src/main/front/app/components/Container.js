import React, {Component} from 'react'
import Navigation from './Navigation'
import Footer from './Footer'

export default class Container extends Component {
    render() {
        return (
            <div>
                <Navigation />
                <div>{this.props.children}</div>
                <Footer />
            </div>
        )
    }
}