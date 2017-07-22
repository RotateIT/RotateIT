package rotateit.domain.github.label;

import com.fasterxml.jackson.annotation.JsonCreator;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class Label {
    private final String name;

    @JsonCreator(mode = PROPERTIES)
    public Label(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
