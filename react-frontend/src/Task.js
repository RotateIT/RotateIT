import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class Task extends Component {
    render() {
        return (
            <button onClick={() => this.gotoUrl(this.props.url)} className="task">
                <div className="title">
                    <a href={this.props.url}>{this.props.title}</a>
                </div>
                <div className="startTime">{this.props.startTime}</div>
            </button>);
    }

    gotoUrl(url) {
        window.location = url;
    }
}

Task.propTypes = {
    url: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    startTime: PropTypes.number.isRequired
}
