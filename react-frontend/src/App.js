import React, {Component} from "react";
import Swimlane from "./Swimlane.js";
import WebSocketUpdater from "./WebSocketUpdater";

export default class App extends Component {

    constructor() {
        super();
        this.state = {
            allSwimlaneData: new Map()
        };
    }

    componentDidMount() {
        this.addSwimlaneData('Gauss', {
            tasks: [
                {title: 'Revert "ETD"', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        this.addSwimlaneData('Maxwell', {
            tasks: [
                {title: 'Add stuff', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        this.addSwimlaneData('Planck', {
            tasks: [
                {title: 'Gradle magic', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't2', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't3', url: 'http://wp.pl', startTime: '12312123123'},
                {title: 't4', url: 'http://wp.pl', startTime: '12312123123'},
            ]
        });
        new WebSocketUpdater(this);
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
        allSwimlaneData.forEach((objectValue, key) => result.push(this.makeSwimlane(key, objectValue)));
        return result;
    }

    makeSwimlane(teamName, swimlaneData) {
        return (<Swimlane title={teamName} tasks={swimlaneData.tasks}/>);
    }

    addSwimlaneData(teamName, swimlaneData) {
        this.setState(function (previousState, props) {
            if (previousState.allSwimlaneData.get(teamName)) {
                let newAllSwimlaneData = new Map(previousState.allSwimlaneData);
                newAllSwimlaneData.get(teamName).tasks.push(swimlaneData.tasks);
                return {allSwimlaneData: newAllSwimlaneData}
            } else {
                let newAllSwimlaneData = new Map(previousState.allSwimlaneData);
                newAllSwimlaneData.set(teamName, swimlaneData);
                return {allSwimlaneData: newAllSwimlaneData}
            }
        });
    }
}
