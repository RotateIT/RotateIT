package rotateit.domain.github.label.event.factory;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.github.label.LabelPayload;

public interface ReviewActionEventFactory {

    ApplicationEvent createReviewActionEvent(LabelPayload labelPayload);
}
