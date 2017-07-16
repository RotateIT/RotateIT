package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class User {
    private final String login;

    @JsonCreator(mode = PROPERTIES)
    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
