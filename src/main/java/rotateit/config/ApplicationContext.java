package rotateit.config;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;
import rotateit.controller.LabelWebhookController;
import rotateit.domain.github.label.event.factory.*;
import rotateit.service.EventPublisher;
import rotateit.service.github.label.OnClosedPullRequestLabelReceivedEventListener;
import rotateit.service.github.label.OnLabelReceivedEventToPersistListener;
import rotateit.service.github.label.OnLabelReceivedEventToViewListener;
import rotateit.service.github.label.OnOpenPullRequestLabelReceivedEventListener;

import java.util.Map;

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
    public OnLabelReceivedEventToPersistListener onLabelReceivedEventToPersistListener() {
        return new OnLabelReceivedEventToPersistListener();
    }

    @Bean
    public OnLabelReceivedEventToViewListener onLabelReceivedEventToViewListener() {
        return new OnLabelReceivedEventToViewListener();
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
}
