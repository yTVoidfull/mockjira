package project.management.domain.model.backlog;

import project.management.domain.model.issue.IssueId;

import java.util.Optional;

public interface BacklogItemRepository {
  void add(BacklogItem backlogItem);

  Optional<BacklogItem> get(IssueId issueId);

  boolean contains(IssueId id);

  void remove(IssueId id);
}
