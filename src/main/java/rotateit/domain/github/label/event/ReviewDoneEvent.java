package rotateit.domain.github.label.event;

import org.springframework.context.ApplicationEvent;

public class ReviewDoneEvent extends ApplicationEvent {
    public ReviewDoneEvent(Object source) {
        super(source);
    }
}
