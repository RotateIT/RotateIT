package rotateit.github.domain;

import static com.google.common.base.Ascii.toUpperCase;

public enum PullRequestState {
    OPEN,
    CLOSED;

    public static PullRequestState fromString(String state) {
        return valueOf(toUpperCase(state));
    }
}
