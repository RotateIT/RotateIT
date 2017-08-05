package rotateit.service.github.label;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rotateit.domain.github.label.LabelPayload;
import rotateit.domain.github.label.LabelReceivedEvent;
import rotateit.domain.github.label.event.factory.ReviewActionEventFactory;
import rotateit.domain.github.label.event.factory.ReviewActionEventFactoryProvider;

@RunWith(SpringJUnit4ClassRunner.class)
public class OnOpenPullRequestLabelReceivedEventListenerTest {

    private final LabelReceivedEvent labelReceivedEvent = mock(LabelReceivedEvent.class);
    private final LabelPayload labelPayload = mock(LabelPayload.class);
    private final ApplicationEvent eventToPublish = mock(ApplicationEvent.class);
    private final ReviewActionEventFactory eventFactory = mock(ReviewActionEventFactory.class);
    @Autowired
    private ReviewActionEventFactoryProvider factoryProvider;
    @Autowired
    private ApplicationEventMulticaster eventMulticaster;
    @Autowired
    private ApplicationContext publishingHelper;
    @Autowired
    private OnOpenPullRequestLabelReceivedEventListener onOpenPullRequestLabelReceivedEventListener;

    @Test
    public void shouldBeConsumedAndPublishedByEventListenerIfLabelReceivedEventWasOnOpenPullRequest() {
        given(labelReceivedEvent.isPullRequestInOpenState()).willReturn(true);
        given(labelReceivedEvent.getSource()).willReturn(labelPayload);
        given(factoryProvider.factoryFor(labelReceivedEvent)).willReturn(eventFactory);
        given(eventFactory.createReviewActionEvent(labelPayload)).willReturn(eventToPublish);

        publishingHelper.publishEvent(labelReceivedEvent);

        then(factoryProvider).should().factoryFor(labelReceivedEvent);
        then(eventMulticaster).should().multicastEvent(eventToPublish);
    }

    @Test
    public void shouldNotBeConsumedNorPublishedByEventListenerIfLabelReceivedEventWasOnClosedPullRequest() {
        given(labelReceivedEvent.isPullRequestInOpenState()).willReturn(false);

        publishingHelper.publishEvent(labelReceivedEvent);

        then(factoryProvider).should(never()).factoryFor(labelReceivedEvent);
        then(eventMulticaster).should(never()).multicastEvent(eventToPublish);
    }

    @Configuration
    protected static class TestConfiguration {
        @Bean
        protected ReviewActionEventFactoryProvider factoryProvider() {
            return mock(ReviewActionEventFactoryProvider.class);
        }

        @Bean
        protected ApplicationEventMulticaster eventMulticaster() {
            return mock(ApplicationEventMulticaster.class);
        }

        @Bean
        protected OnOpenPullRequestLabelReceivedEventListener onOpenPullRequestLabelReceivedEventListener(
            ReviewActionEventFactoryProvider factoryProvider, ApplicationEventMulticaster eventMulticaster) {
            return new OnOpenPullRequestLabelReceivedEventListener(factoryProvider, eventMulticaster);
        }
    }
}
