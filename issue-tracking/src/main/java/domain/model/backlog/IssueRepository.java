package domain.model.backlog;

import domain.model.backlog.Issue;
import domain.model.backlog.IssueId;

import java.util.Optional;

public interface IssueRepository {
  void add(Issue i);

  Optional<Issue> get(IssueId issue);

  boolean contains(Issue i);
}
