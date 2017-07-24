package rotateit.domain.github.label.event;

import org.springframework.context.ApplicationEvent;

public class TakenForReviewEvent extends ApplicationEvent {
    public TakenForReviewEvent(Object source) {
        super(source);
    }
}
