package rotateit.service.rotation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rotateit.data.model.Team;
import rotateit.domain.github.label.LabelPayload;
import rotateit.domain.github.label.event.ReadyForReviewEvent;
import rotateit.domain.rotation.event.PullRequestAssignedEvent;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReadyForReviewEventListenerTest {

    private final LabelPayload labelPayload = mock(LabelPayload.class);
    private final ReadyForReviewEvent readyForReviewEvent = mock(ReadyForReviewEvent.class);
    private final Team team = mock(Team.class);
    @Autowired
    private Rotator rotator;
    @Autowired
    private ApplicationEventMulticaster eventMulticaster;
    @Autowired
    private ApplicationContext publishingHelper;

    @Before
    public void setUp() {
        reset(rotator, eventMulticaster);
    }

    @Test
    public void shouldBeConsumedAndPublishedByEventListener() {
        given(rotator.rotate()).willReturn(team);
        given(readyForReviewEvent.getSource()).willReturn(labelPayload);

        publishingHelper.publishEvent(readyForReviewEvent);

        then(rotator).should().rotate();
        then(eventMulticaster).should().multicastEvent(isA(PullRequestAssignedEvent.class));
    }

    @Test
    public void shouldNotBeConsumedIfEventIsNotOfReadyForReviewEventType() {
        ApplicationEvent someEvent = mock(ApplicationEvent.class);

        publishingHelper.publishEvent(someEvent);

        then(rotator).should(never()).rotate();
        then(eventMulticaster).should(never()).multicastEvent(any());
    }

    @Configuration
    protected static class TestConfiguration {
        @Bean
        protected Rotator rotator() {
            return mock(Rotator.class);
        }

        @Bean
        protected ApplicationEventMulticaster eventMulticaster() {
            return mock(ApplicationEventMulticaster.class);
        }

        @Bean
        protected ReadyForReviewEventListener readyForReviewEventListener(
            Rotator rotator, ApplicationEventMulticaster eventMulticaster) {
            return new ReadyForReviewEventListener(rotator, eventMulticaster);
        }
    }
}
