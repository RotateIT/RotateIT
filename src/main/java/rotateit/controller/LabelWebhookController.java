package rotateit.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static rotateit.domain.github.label.LabelReceivedEvent.aLabelReceivedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rotateit.domain.github.label.LabelPayload;
import rotateit.service.EventPublisher;

@RestController
public class LabelWebhookController {

    private final EventPublisher eventPublisher;

    @Autowired
    public LabelWebhookController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(value = "/api/github/labelWebhookRequest", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public void labelWebhookRequest(@RequestBody LabelPayload labelPayload) {
        eventPublisher.publish(aLabelReceivedEvent(labelPayload));
    }
}
