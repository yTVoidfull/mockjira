package project.management.domain.model.sprint;

import project.management.domain.model.ProjectCode;

import java.util.Objects;

public class SprintId {
  private final String SPRINT_ID_FOMAT = "%s-s%d";

  private ProjectCode projectCode;
  private int id;

  public SprintId(ProjectCode projectCode, int id) {
    this.projectCode = projectCode;
    this.id = id;
  }

  public static SprintId of(ProjectCode projectCode, int id){
    return new SprintId(projectCode, id);
  }

  public String getId(){
    return String.format(SPRINT_ID_FOMAT, projectCode,id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SprintId)) return false;
    SprintId sprintId = (SprintId) o;
    return id == sprintId.id &&
        Objects.equals(projectCode, sprintId.projectCode);
  }

}
