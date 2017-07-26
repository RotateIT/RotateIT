export default class WebSocketUpdater {

    constructor(app) {
        let reviewsSocket = new WebSocket('ws://' + window.location.hostname + ':8080/reviews');

        reviewsSocket.onmessage = function (message) {
            let newTask = JSON.parse(message.data);

            let teamName = newTask.assignedTeam.name;
            let swimlaneData = {
                teamName: {
                    tasks: [
                        {title: newTask.title, url: newTask.url, startTime: newTask.startTime}
                    ]
                }
            };
            console.log("Adding task: " + swimlaneData);
            app.addSwimlaneData(swimlaneData);
        };

        reviewsSocket.onopen = function (message) {
            console.log("WebSocket connected!");
        };

        reviewsSocket.onclose = function (message) {
            console.log("WebSocket connection closed!");
        };
    }
};
