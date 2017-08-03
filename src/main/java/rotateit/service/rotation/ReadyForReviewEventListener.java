package rotateit.service.rotation;

import org.springframework.context.event.EventListener;
import rotateit.data.model.Team;
import rotateit.domain.github.label.event.ReadyForReviewEvent;
import rotateit.domain.rotation.PullRequestAssigned;
import rotateit.domain.rotation.event.PullRequestAssignedEvent;

public class ReadyForReviewEventListener {

    private final Rotator rotaror;

    public ReadyForReviewEventListener(Rotator rotaror) {
        this.rotaror = rotaror;
    }

    @EventListener
    public PullRequestAssignedEvent onEvent(ReadyForReviewEvent readyForReviewEvent) {
        Team assignedTeam = rotaror.rotate();
        PullRequestAssigned pullRequestAssigned = new PullRequestAssigned(readyForReviewEvent.getSource(), assignedTeam);
        return new PullRequestAssignedEvent(pullRequestAssigned);
    }
}
