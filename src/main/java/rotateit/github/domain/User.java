package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User {
    private final String login;

    @JsonCreator
    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
