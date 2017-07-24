package rotateit.domain.github.label.event.factory;

import org.springframework.context.ApplicationEvent;

public interface ReviewActionEventFactory {

    ApplicationEvent createReviewActionEvent(Object source);
}
