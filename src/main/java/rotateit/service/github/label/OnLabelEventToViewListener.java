package rotateit.service.github.label;

import org.springframework.context.event.EventListener;
import rotateit.domain.github.label.LabelEvent;

public class OnLabelEventToViewListener {

    @EventListener
    public void onEvent(LabelEvent labelEvent) {
    }
}
