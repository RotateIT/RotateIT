package rotateit.service.rotation;

import java.util.Deque;
import rotateit.data.model.Team;

public class Rotator {

    private final Deque<Team> rotationState;

    public Rotator(Deque<Team> rotationState) {
        this.rotationState = rotationState;
    }

    public Team rotate() {
        synchronized (this) {
            Team pickedTeam = rotationState.pollFirst();
            rotationState.offerLast(pickedTeam);
            return pickedTeam;
        }
    }

}
