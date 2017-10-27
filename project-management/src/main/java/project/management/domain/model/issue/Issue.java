package project.management.domain.model.issue;

import java.util.Objects;

import static commons.InputAssertion.assertNotNull;

public class Issue {

  private IssueId id;
  boolean isOpen;

  private Issue(IssueId id) {
    this.id = id;
    this.isOpen = true;
  }

  public static Issue of(IssueId id){
    assertNotNull(id, "Issue id must not be null");
    return new Issue(id);
  }

  public IssueId getId() {
    return id;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void close() {
    isOpen = false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Issue)) return false;
    Issue that = (Issue) o;
    return isOpen == that.isOpen &&
        Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isOpen);
  }
}
