package rotateit.github.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Label {
    private final String name;

    @JsonCreator
    public Label(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
