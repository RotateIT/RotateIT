package rotateit.service.rotation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Before;
import org.junit.Test;
import rotateit.data.model.Team;

public class RotatorTest {

    private static final String FIRST = "First";
    private static final String AFTER_FIRST = "AfterFirst";
    private static final String BEFORE_LAST = "BeforeLast";
    private static final String LAST = "Last";

    private final Deque<Team> rotationState = new ArrayDeque<>();

    private final Rotator rotator = new Rotator(rotationState);

    @Before
    public void setUp() {
        rotationState.clear();
    }

    private void givenRotationList() {
        rotationState.add(new Team(1, FIRST));
        rotationState.add(new Team(2, AFTER_FIRST));
        rotationState.add(new Team(3, BEFORE_LAST));
        rotationState.add(new Team(4, LAST));
    }

    @Test
    public void shouldPickFirstTeamFromListAndMoveItToEnd() {
        givenRotationList();

        Team pickedTeam = rotator.rotate();

        assertThat(pickedTeam.getName()).isEqualTo(FIRST);
        assertThat(pickedTeam).isEqualTo(rotationState.getLast());
    }

    @Test
    public void shouldKeepChangingOrderOfTeamsAfterMultipleRotations() {
        givenRotationList();

        Team firstPick = rotator.rotate();
        Team secondPick = rotator.rotate();
        Team thirdPick = rotator.rotate();

        assertThat(firstPick.getName()).isEqualTo(FIRST);
        assertThat(secondPick.getName()).isEqualTo(AFTER_FIRST);
        assertThat(thirdPick.getName()).isEqualTo(BEFORE_LAST);
        assertThat(thirdPick).isEqualTo(rotationState.getLast());
    }
}
