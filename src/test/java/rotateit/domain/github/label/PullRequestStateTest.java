package rotateit.domain.github.label;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.internal.util.collections.Sets.newSet;
import static rotateit.domain.github.label.PullRequestState.*;

@RunWith(JUnitParamsRunner.class)
public class PullRequestStateTest {

    @Test
    @Parameters(method = "statesTreatedAsOpen")
    public void shouldCreateOpenStateBasedOnStringStateRepresentation(String stateAsString) {
        PullRequestState state = fromString(stateAsString);

        assertThat(state).isEqualTo(OPEN);
    }

    public Set<String> statesTreatedAsOpen() {
        return newSet("open", "oPeN", "OPEN");
    }

    @Test
    @Parameters(method = "statesTreatedAsClosed")
    public void shouldCreateClosedStateBasedOnStringStateRepresentation(String stateAsString) {
        PullRequestState state = fromString(stateAsString);

        assertThat(state).isEqualTo(CLOSED);
    }

    public Set<String> statesTreatedAsClosed() {
        return newSet("closed", "cLoSeD", "CLOSED");
    }

    @Test
    public void shouldCorrectlyRecognizeOpenState() {
        assertThat(OPEN.isOpen()).isTrue();
    }

    @Test
    public void shouldCorrectlyRecognizeNotOpenState() {
        assertThat(CLOSED.isOpen()).isFalse();
    }

    //TODO: test handling of exception during conversion from string
}
