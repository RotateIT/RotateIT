package rotateit.domain.github.label;

import org.springframework.context.ApplicationEvent;

public class LabelReceivedEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private LabelReceivedEvent(LabelPayload labelPayload) {
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

    public static LabelReceivedEvent aLabelReceivedEvent(LabelPayload labelPayload) {
        return new LabelReceivedEvent(labelPayload);
    }
}
