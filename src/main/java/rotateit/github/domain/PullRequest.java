package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static rotateit.github.domain.PullRequestState.fromString;

public class PullRequest {
    private final String number;
    private final String htmlUrl;
    private final PullRequestState pullRequestState;
    private final String title;
    private final User user;

    @JsonCreator
    public PullRequest(@JsonProperty("number") String number, @JsonProperty("html_url") String htmlUrl,
                       @JsonProperty("state") String state, @JsonProperty("title") String title,
                       @JsonProperty("user") User user) {
        this.number = number;
        this.htmlUrl = htmlUrl;
        this.pullRequestState = fromString(state);
        this.title = title;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public PullRequestState getPullRequestState() {
        return pullRequestState;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
