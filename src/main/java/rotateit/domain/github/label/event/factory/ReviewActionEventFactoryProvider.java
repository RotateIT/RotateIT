package rotateit.domain.github.label.event.factory;

import java.util.Map;
import rotateit.domain.github.label.LabelReceivedEvent;

public class ReviewActionEventFactoryProvider {

    private final Map<String, ReviewActionEventFactory> pullRequestEventFactories;
    private final ReviewActionEventFactory defaultReviewActionEventFactory;

    public ReviewActionEventFactoryProvider(Map<String, ReviewActionEventFactory> pullRequestEventFactories,
                                            ReviewActionEventFactory defaultReviewActionEventFactory) {
        this.pullRequestEventFactories = pullRequestEventFactories;
        this.defaultReviewActionEventFactory = defaultReviewActionEventFactory;
    }

    public ReviewActionEventFactory factoryFor(LabelReceivedEvent labelReceivedEvent) {
        String reviewAction = labelReceivedEvent.getSource().getLabel().getName();
        return pullRequestEventFactories.getOrDefault(reviewAction, defaultReviewActionEventFactory);
    }
}
