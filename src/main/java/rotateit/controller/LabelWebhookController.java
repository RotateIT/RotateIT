package rotateit.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rotateit.domain.github.label.LabelPayload;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LabelWebhookController {
    @RequestMapping(value = "/api/github/labelWebhookRequest", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public void labelWebhookRequest(@RequestBody LabelPayload labelPayload) {

    }
}
