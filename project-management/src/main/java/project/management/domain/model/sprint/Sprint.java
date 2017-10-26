package project.management.domain.model.sprint;

import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Sprint {

  private Set<Issue> sprintIssueSet;
  private final SprintId id;

  private Sprint(SprintId id) {
    this.id = id;
    sprintIssueSet = new HashSet<>();
  }

  public void add(Issue sprintIssue) {
    sprintIssueSet.add(sprintIssue);
  }

  public Optional<Issue> get(IssueId id) {
    return sprintIssueSet.stream()
        .filter(issue -> issue.getId().equals(id))
        .findAny();
  }

  public static Sprint of(SprintId id) {
    return new Sprint(id);
  }
}
