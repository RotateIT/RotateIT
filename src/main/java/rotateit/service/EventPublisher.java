package rotateit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;

public class EventPublisher {

    private final ApplicationEventMulticaster eventMulticaster;

    @Autowired
    public EventPublisher(ApplicationEventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    public void publish(ApplicationEvent event) {
        eventMulticaster.multicastEvent(event);
    }
}
