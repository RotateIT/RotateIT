package rotateit.domain.github.label.event.factory;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.github.label.LabelPayload;
import rotateit.domain.github.label.event.UnknownReviewActionEvent;

public class UnknownReviewActionEventFactory implements ReviewActionEventFactory {
    @Override
    public ApplicationEvent createReviewActionEvent(LabelPayload labelPayload) {
        return new UnknownReviewActionEvent(labelPayload);
    }
}
