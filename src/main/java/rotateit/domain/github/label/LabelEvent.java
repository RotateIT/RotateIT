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

    public boolean isPullRequestInOpenState() {
        //TODO: NPE shouldn't happen here, we should verify if LabelPayload have all required fields during creation, will address this in near future
        return getSource().isPullRequestInOpenState();
    }

    public static LabelEvent aLabelEvent(LabelPayload labelPayload) {
        return new LabelEvent(labelPayload);
    }
}
