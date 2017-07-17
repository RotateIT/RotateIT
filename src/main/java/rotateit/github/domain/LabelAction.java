package rotateit.github.domain;

import static com.google.common.base.Ascii.toUpperCase;

public enum LabelAction {
    LABELED,
    UNLABELED;

    public static LabelAction fromString(String labelAction) {
        return valueOf(toUpperCase(labelAction));
    }
}
