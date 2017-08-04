package rotateit.domain.github.label.event;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.github.label.LabelPayload;

public class UnknownReviewActionEvent extends ApplicationEvent {
    public UnknownReviewActionEvent(LabelPayload labelPayload) {
        super(labelPayload);
    }

    @Override
    public LabelPayload getSource() {
        return (LabelPayload) super.getSource();
    }
}
