package project.management.domain.model.project;

public class ClosedProject {

  private ProjectCode projectCode;

  public ClosedProject(ProjectCode projectCode) {
    this.projectCode = projectCode;
  }

  public ProjectCode getProjectCode() {
    return projectCode;
  }
}
