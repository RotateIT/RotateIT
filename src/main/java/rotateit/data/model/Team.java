package rotateit.data.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("PMD.UncommentedEmptyConstructor")
@Entity
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int teamId;

    @Column(nullable = false)
    private String name;

    public Team() {
    }

    public Team(int teamId, String name) {
        this.teamId = teamId;
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
