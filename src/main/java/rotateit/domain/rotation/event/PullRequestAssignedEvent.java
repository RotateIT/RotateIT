package rotateit.domain.rotation.event;

import org.springframework.context.ApplicationEvent;
import rotateit.domain.rotation.PullRequestAssigned;

public class PullRequestAssignedEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public PullRequestAssignedEvent(PullRequestAssigned pullRequestAssigned) {
        super(pullRequestAssigned);
    }

    @Override
    public PullRequestAssigned getSource() {
        return (PullRequestAssigned) super.getSource();
    }
}
