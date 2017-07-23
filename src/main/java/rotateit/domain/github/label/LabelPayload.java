package rotateit.domain.github.label;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static rotateit.domain.github.label.LabelAction.fromString;

public class LabelPayload {
    private final LabelAction labelAction;
    private final PullRequest pullRequest;
    private final Label label;

    @JsonCreator
    public LabelPayload(@JsonProperty("action") String action, @JsonProperty("pull_request") PullRequest pullRequest,
                        @JsonProperty("label") Label label) {
        this.labelAction = fromString(action);
        this.pullRequest = pullRequest;
        this.label = label;
    }

    public LabelAction getLabelAction() {
        return labelAction;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public Label getLabel() {
        return label;
    }

    public boolean isPullRequestInOpenState() {
        return pullRequest.isOpen();
    }
}
