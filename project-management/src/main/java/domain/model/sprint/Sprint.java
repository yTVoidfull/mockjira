package domain.model.sprint;

import domain.model.issue.Issue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Sprint {

  private Set<Issue> sprintIssueSet;
  private final int id;

  private Sprint(int id) {
    this.id = id;
    sprintIssueSet = new HashSet<>();
  }

  public int getId() {
    return id;
  }

  public void add(Issue sprintIssue) {
    sprintIssueSet.add(sprintIssue);
  }

  public Optional<Issue> get(String id) {
    return sprintIssueSet.stream()
        .filter(issue -> issue.getId().equals(id))
        .findAny();
  }

  public static Sprint of(int i) {
    return new Sprint(1);
  }
}
