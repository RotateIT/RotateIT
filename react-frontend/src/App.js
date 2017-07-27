import React, {Component} from "react";
import Swimlane from "./Swimlane.js";

export default class App extends Component {

    constructor() {
        super();
        let tempAllSwimlaneData = new Map();
        tempAllSwimlaneData.set('Gauss', {
            tasks: [
                {title: 'Revert "ETD"', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        tempAllSwimlaneData.set('Maxwell', {
            tasks: [
                {title: 'Add stuff', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        tempAllSwimlaneData.set('Planck', {
            tasks: [
                {title: 'Gradle magic', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't3', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't4', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        this.state = {
            allSwimlaneData: tempAllSwimlaneData
        }
    }

    render() {
        return (
            <div className="App">
                <h1 className="title">RotateIT</h1>
                {this.buildAllSwimlaneData(this.state.allSwimlaneData)}
            </div>
        );
    }

    buildAllSwimlaneData(allSwimlaneData) {
        let result = [];
        allSwimlaneData.forEach((object, key) => result.push(this.makeSwimlane(object, key)));
        return result;
    }

    makeSwimlane(swimlaneData, key) {
        return (<Swimlane title={key} tasks={swimlaneData.tasks}/>);
    }
}
