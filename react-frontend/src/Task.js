import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class Task extends React.Component {
    render() {
        return (
            <div className="task">
                <div className="title">
                    <a href={this.props.url}>{this.props.title}</a>
                </div>
                <div className="startTime">{this.props.startTime}</div>
            </div>);
    }
}

Task.propTypes = {
    url: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    startTime: PropTypes.number.isRequired
}
