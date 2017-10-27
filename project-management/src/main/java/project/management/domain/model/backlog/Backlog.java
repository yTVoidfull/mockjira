package project.management.domain.model.backlog;

import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;
import project.management.domain.model.user.Username;

public class Backlog {

  private BacklogItemRepository backlogItemRepository;
  private SprintRepository sprintRepository;

  public Backlog(BacklogItemRepository backlogItemRepository, SprintRepository sprintRepository) {
    this.backlogItemRepository = backlogItemRepository;
    this.sprintRepository = sprintRepository;
  }

  public void add(Issue i) {
    BacklogItem backlogItem = new BacklogItem();
    backlogItem.setId(i.getId())
        .setName("name")
        .setStoryPoints(0)
        .setUsername(new Username("username"));

    backlogItemRepository.add(backlogItem);
  }

  public boolean contains(IssueId issueId) {
    return backlogItemRepository.contains(issueId);
  }

  public void add(Sprint sprint) {
    sprintRepository.add(sprint);
  }

  public boolean contains(SprintId sprintId) {
    return sprintRepository.contains(sprintId);
  }

  public void remove(SprintId sprintId) {
    sprintRepository.remove(sprintId);
  }
}
