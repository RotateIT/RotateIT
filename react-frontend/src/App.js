import React, { Component } from 'react';
import Swimlane from './Swimlane.js'

export default class App extends Component {

    constructor() {
        super();
        this.state = {
            teams: [
                {
                    name: 'Gauss',
                    tasks: [
                        { title: 'Revert "ETD"', url: 'http://wp.pl', startTime: '12312123123' },
                        { title: 't2', url: 'http://wp.pl', startTime: '12312123123' },
                    ]
                },
                {
                    name: 'Maxwell',
                    tasks: [
                        { title: 'Add stuff', url: 'http://wp.pl', startTime: '12312123123' },
                    ]
                },
                {
                    name: 'Planck',
                    tasks: [
                        { title: 'Gradle magic', url: 'http://wp.pl', startTime: '12312123123' },
                        { title: 't2', url: 'http://wp.pl', startTime: '12312123123' },
                        { title: 't3', url: 'http://wp.pl', startTime: '12312123123' },
                        { title: 't4', url: 'http://wp.pl', startTime: '12312123123' },
                    ]
                },
            ]
        }
    }

    render() {
        return (
            <div className="App">
                <h1 className="title">RotateIT</h1>
                {this.state.teams.map(this.makeSwimlane)}
            </div>
        );
    }

    makeSwimlane(team) {
        return (<Swimlane title={team.name} tasks={team.tasks} />);
    }
}
