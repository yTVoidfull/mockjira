package project.management.domain.model.backlog;

import project.management.domain.model.issue.IssueId;
import project.management.domain.model.user.User;
import project.management.domain.model.user.Username;

public class BacklogItem {

  private IssueId id;
  private String name;
  private Username username;
  private int storyPoints;

  public BacklogItem(IssueId id, String name, Username username, int storyPoints) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.storyPoints = storyPoints;
  }

  public BacklogItem() {
  }

  public IssueId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Username getUsername() {
    return username;
  }

  public int getStoryPoints() {
    return storyPoints;
  }

  public BacklogItem setId(IssueId id) {
    this.id = id;
    return this;
  }

  public BacklogItem setName(String name) {
    this.name = name;
    return this;
  }

  public BacklogItem setStoryPoints(int storyPoints) {
    this.storyPoints = storyPoints;
    return this;
  }

  public BacklogItem setUsername(Username username) {
    this.username = username;
    return this;
  }
}
