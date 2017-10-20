package domain.model;

import java.util.Optional;

public interface IssueRepository {
  void add(Issue i);

  Optional<Issue> getIssueBy(IssueId issue);

  boolean contains(Issue i);
}
