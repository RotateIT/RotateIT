package rotateit.config;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;
import rotateit.controller.LabelWebhookController;
import rotateit.domain.github.label.event.factory.ReadyForReviewEventFactory;
import rotateit.domain.github.label.event.factory.ReviewActionEventFactory;
import rotateit.domain.github.label.event.factory.ReviewActionEventFactoryProvider;
import rotateit.domain.github.label.event.factory.ReviewDoneEventFactory;
import rotateit.domain.github.label.event.factory.TakenForReviewEventFactory;
import rotateit.domain.github.label.event.factory.UnknownReviewActionEventFactory;
import rotateit.service.EventPublisher;
import rotateit.service.github.label.OnClosedPullRequestLabelReceivedEventListener;
import rotateit.service.github.label.OnOpenPullRequestLabelReceivedEventListener;
import rotateit.service.rotation.ReadyForReviewEventListener;
import rotateit.service.rotation.Rotator;

@Configuration
public class ApplicationContext {

    @Bean
    public ApplicationEventMulticaster eventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        eventMulticaster.setErrorHandler(TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);
        return eventMulticaster;
    }

    @Bean
    public EventPublisher eventPublisher(ApplicationEventMulticaster applicationEventMulticaster) {
        return new EventPublisher(applicationEventMulticaster);
    }

    @Bean
    public LabelWebhookController labelWebhookController(EventPublisher eventPublisher) {
        return new LabelWebhookController(eventPublisher);
    }

    @Bean
    public OnClosedPullRequestLabelReceivedEventListener onClosedPullRequestLabelEventListener() {
        return new OnClosedPullRequestLabelReceivedEventListener();
    }

    @Bean
    public ReviewActionEventFactoryProvider factoryProvider() {
        Map<String, ReviewActionEventFactory> reviewActionFactories = ImmutableMap.<String, ReviewActionEventFactory>builder()
            .put("Ready For Review", new ReadyForReviewEventFactory())
            .put("Taken For Review", new TakenForReviewEventFactory())
            .put("Review Done", new ReviewDoneEventFactory())
            .build();

        return new ReviewActionEventFactoryProvider(reviewActionFactories, new UnknownReviewActionEventFactory());
    }

    @Bean
    public OnOpenPullRequestLabelReceivedEventListener onOpenPullRequestLabelReceivedEventListener(
        ReviewActionEventFactoryProvider factoryProducer, ApplicationEventMulticaster eventMulticaster) {
        return new OnOpenPullRequestLabelReceivedEventListener(factoryProducer, eventMulticaster);
    }

    @Bean
    public Rotator rotator() {
        return new Rotator();
    }

    @Bean
    public ReadyForReviewEventListener readyForReviewEventListener(Rotator rotator, ApplicationEventMulticaster eventMulticaster) {
        return new ReadyForReviewEventListener(rotator, eventMulticaster);
    }
}
