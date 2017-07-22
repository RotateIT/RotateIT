package rotateit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;
import rotateit.controller.LabelWebhookController;
import rotateit.service.EventPublisher;
import rotateit.service.github.label.OnLabelEventToPersistListener;
import rotateit.service.github.label.OnLabelEventToViewListener;

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
    public OnLabelEventToPersistListener onLabelEventToPersistListener() {
        return new OnLabelEventToPersistListener();
    }

    @Bean
    public OnLabelEventToViewListener onLabelEventToViewListener() {
        return new OnLabelEventToViewListener();
    }
}
