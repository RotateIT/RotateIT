import React, { Component } from 'react';

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
