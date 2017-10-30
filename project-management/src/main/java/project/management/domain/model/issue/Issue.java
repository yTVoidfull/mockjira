package project.management.domain.model.issue;

import java.util.Objects;

public class Issue {

  private IssueId id;
  private IssueStatus status;

  private Issue(IssueId id) {
    this.id = id;
    status = IssueStatus.OPEN;
  }

  public static Issue of(IssueId id){
    return new Issue(id);
  }

  public IssueId getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Issue)) return false;
    Issue issue = (Issue) o;
    return Objects.equals(id, issue.id) &&
        status == issue.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  public IssueStatus getStatus() {
    return status;
  }

  public void changeStatus(IssueStatusModifier modifier){
    this.status = modifier.invokeOn(this.status);
  }

}
