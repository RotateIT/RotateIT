import React, {Component} from "react";
import Swimlane from "./Swimlane.js";

export default class App extends Component {

    constructor() {
        super();
        this.state = {
            allSwimlaneData: {
                'Gauss': {
                    tasks: [
                        {title: 'Revert "ETD"', url: 'http://wp.pl', startTime: '12312123123'},
                        {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
                    ]
                },
                'Maxwell': {
                    tasks: [
                        {title: 'Add stuff', url: 'http://wp.pl', startTime: '12312123123'},
                    ]
                },
                'Planck': {
                    tasks: [
                        {title: 'Gradle magic', url: 'http://wp.pl', startTime: '12312123123'},
                        {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
                        {title: 't3', url: 'http://wp.pl', startTime: '12312123123'},
                        {title: 't4', url: 'http://wp.pl', startTime: '12312123123'},
                    ]
                }
            }
        };
    }

    render() {
        return (
            <div className="App">
                <h1 className="title">RotateIT</h1>
                {this.printAllSwimlaneData(this.state.allSwimlaneData)}
            </div>
        );
    }

    printAllSwimlaneData(allSwimlaneData) {
        let result = [];
        allSwimlaneData.forEach((swimlaneData) => result.push(this.makeSwimlane(swimlaneData)));
        return result;
    }

    makeSwimlane(swimlaneData) {
        return (<Swimlane title={swimlaneData.title} tasks={swimlaneData.tasks}/>);
    }
}
