package rotateit.service.github.label;

import org.springframework.context.event.EventListener;
import rotateit.domain.github.label.LabelReceivedEvent;

public class OnLabelReceivedEventToViewListener {

    @EventListener(condition = "#labelReceivedEvent.pullRequestInOpenState")
    public void onEvent(LabelReceivedEvent labelReceivedEvent) {
    }
}
