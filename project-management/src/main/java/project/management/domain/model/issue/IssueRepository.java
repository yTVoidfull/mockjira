package project.management.domain.model.issue;

import java.util.Optional;

public interface IssueRepository {
  void add(Issue i);

  boolean contains(Issue i);

  Optional<Issue> get(IssueId id);

  void remove(Issue i);
}
