package project.management.infrastructure.persistence;

import project.management.domain.model.backlog.BacklogItem;
import project.management.domain.model.backlog.BacklogItemRepository;
import project.management.domain.model.issue.IssueId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBacklogItemRepository implements BacklogItemRepository{

  List<BacklogItem> backlogItemList;

  public InMemoryBacklogItemRepository() {
    this.backlogItemList = new ArrayList<>();
  }

  public void add(BacklogItem backlogItem) {
    backlogItemList.add(backlogItem);
  }

  @Override
  public Optional<BacklogItem> get(IssueId issueId) {
    return backlogItemList.stream()
        .filter(backlogItem -> backlogItem.getId().equals(issueId))
        .findAny();
  }

  @Override
  public boolean contains(IssueId id) {
    return backlogItemList.stream()
        .anyMatch(backlogItem -> backlogItem.getId().equals(id));
  }

  @Override
  public void remove(IssueId id) {
    backlogItemList.removeIf(backlogItem -> backlogItem.getId().equals(id));
  }


}
