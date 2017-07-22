package rotateit.domain.github.label;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("unchecked")
public class LabelEvent extends ApplicationEvent {

    private LabelEvent(LabelPayload labelPayload) {
        super(labelPayload);
    }

    @Override
    public LabelPayload getSource() {
        return (LabelPayload) super.getSource();
    }

    public static LabelEvent aLabelEvent(LabelPayload labelPayload) {
        return new LabelEvent(labelPayload);
    }
}
