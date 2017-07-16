package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PullRequest {
    private final String number;
    private final String htmlUrl;
    private final String state;
    private final String title;
    private final User user;

    @JsonCreator
    public PullRequest(@JsonProperty("number") String number, @JsonProperty("html_url") String htmlUrl,
                       @JsonProperty("state") String state, @JsonProperty("title") String title,
                       @JsonProperty("user") User user) {
        this.number = number;
        this.htmlUrl = htmlUrl;
        this.state = state;
        this.title = title;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
}
