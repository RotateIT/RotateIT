package rotate.it.data.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Team implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private int teamId;

  @Column(nullable = false)
  private String name;

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
