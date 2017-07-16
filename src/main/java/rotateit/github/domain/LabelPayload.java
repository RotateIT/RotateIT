package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelPayload {
    private final String action;
    private final PullRequest pullRequest;
    private final Label label;

    @JsonCreator
    public LabelPayload(@JsonProperty("action") String action, @JsonProperty("pull_request") PullRequest pullRequest,
                        @JsonProperty("label") Label label) {
        this.action = action;
        this.pullRequest = pullRequest;
        this.label = label;
    }

    public String getAction() {
        return action;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public Label getLabel() {
        return label;
    }
}
