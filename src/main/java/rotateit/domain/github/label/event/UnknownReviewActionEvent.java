package rotateit.domain.github.label.event;

import org.springframework.context.ApplicationEvent;

public class UnknownReviewActionEvent extends ApplicationEvent {
    public UnknownReviewActionEvent(Object source) {
        super(source);
    }
}
