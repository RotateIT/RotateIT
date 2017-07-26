package rotateit.domain.github.label.event.factory;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.github.label.event.UnknownReviewActionEvent;

public class UnknownReviewActionEventFactory implements ReviewActionEventFactory {
    @Override
    public ApplicationEvent createReviewActionEvent(Object source) {
        return new UnknownReviewActionEvent(source);
    }
}
