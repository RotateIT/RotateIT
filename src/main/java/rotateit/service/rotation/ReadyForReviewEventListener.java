package rotateit.service.rotation;

import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import rotateit.data.model.Team;
import rotateit.domain.github.label.event.ReadyForReviewEvent;
import rotateit.domain.rotation.PullRequestAssigned;
import rotateit.domain.rotation.event.PullRequestAssignedEvent;

public class ReadyForReviewEventListener {

    private final Rotator rotaror;
    private final ApplicationEventMulticaster eventMulticaster;

    public ReadyForReviewEventListener(Rotator rotaror, ApplicationEventMulticaster eventMulticaster) {
        this.rotaror = rotaror;
        this.eventMulticaster = eventMulticaster;
    }

    @EventListener
    public void onEvent(ReadyForReviewEvent readyForReviewEvent) {
        Team assignedTeam = rotaror.rotate();
        PullRequestAssigned pullRequestAssigned = new PullRequestAssigned(readyForReviewEvent.getSource(), assignedTeam);
        eventMulticaster.multicastEvent(new PullRequestAssignedEvent(pullRequestAssigned));
    }
}
