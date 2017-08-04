package rotateit.service.github.label;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import rotateit.domain.github.label.LabelReceivedEvent;
import rotateit.domain.github.label.event.factory.ReviewActionEventFactoryProvider;

public class OnOpenPullRequestLabelReceivedEventListener {

    private final ReviewActionEventFactoryProvider factoryProvider;
    private final ApplicationEventMulticaster eventMulticaster;

    public OnOpenPullRequestLabelReceivedEventListener(ReviewActionEventFactoryProvider factoryProvider,
                                                       ApplicationEventMulticaster eventMulticaster) {
        this.factoryProvider = factoryProvider;
        this.eventMulticaster = eventMulticaster;
    }

    @EventListener(condition = "#labelReceivedEvent.pullRequestInOpenState")
    public void onEvent(LabelReceivedEvent labelReceivedEvent) {
        ApplicationEvent event = factoryProvider.factoryFor(labelReceivedEvent).createReviewActionEvent(labelReceivedEvent.getSource());
        eventMulticaster.multicastEvent(event);
    }
}
