package rotateit.domain.github.label.event.factory;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.github.label.event.TakenForReviewEvent;

public class TakenForReviewEventFactory implements ReviewActionEventFactory {
    @Override
    public ApplicationEvent createReviewActionEvent(Object source) {
        return new TakenForReviewEvent(source);
    }
}
