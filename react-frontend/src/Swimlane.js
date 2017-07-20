import React, { Component } from 'react';
import Task from './Task.js'

export default class Swimlane extends React.Component {
    render() {
        return (
            <div className="swimlane">
                <div className="title">{this.props.title}</div>
                {this.props.tasks.map(this.makeTask)}
            </div>);
    }

    makeTask(task) {
        return (
            <Task
                title={task.title}
                url={task.url}
                startTime={task.startTime}
            />
        );
    }
}
