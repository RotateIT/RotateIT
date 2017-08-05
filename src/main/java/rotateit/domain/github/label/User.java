package rotateit.domain.github.label;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

import com.fasterxml.jackson.annotation.JsonCreator;

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
