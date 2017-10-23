package domain.model.backlog;

public class OpenProject {

  private ProjectCode code;
  private IssueCounter issueCounter;

  public OpenProject(ProjectCode code, IssueCounter issueCounter) {
    this.code = code;
    this.issueCounter = issueCounter;
  }

  public ProjectCode getCode() {
    return code;
  }

  public Issue open() {
      return Issue.openFor(code, issueCounter.getANewId());
  }
}
