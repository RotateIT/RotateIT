package rotateit.uidto;

public class UiUser {

    private final String name;
    private final UiTeam uiTeam;

    public UiUser(String name, UiTeam uiTeam) {
        this.name = name;
        this.uiTeam = uiTeam;
    }

    public String getName() {
        return name;
    }

    public UiTeam getUiTeam() {
        return uiTeam;
    }
}
