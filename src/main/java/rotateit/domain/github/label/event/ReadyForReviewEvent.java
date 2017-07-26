package rotateit.domain.github.label.event;

import org.springframework.context.ApplicationEvent;

public class ReadyForReviewEvent extends ApplicationEvent {
    public ReadyForReviewEvent(Object source) {
        super(source);
    }
}
