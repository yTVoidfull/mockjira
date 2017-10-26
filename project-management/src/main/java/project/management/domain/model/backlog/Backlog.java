package project.management.domain.model.backlog;

import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.issue.IssueRepository;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintRepository;

import java.util.Optional;

public class Backlog {

  private IssueRepository issueRepository;
  private SprintRepository sprintRepository;

  public Backlog(IssueRepository issueRepository, SprintRepository sprintRepository) {
    this.issueRepository = issueRepository;
    this.sprintRepository = sprintRepository;
  }


  public void add(Issue i) {
    issueRepository.add(i);
  }

  public Optional<Issue> get(IssueId id){
    return issueRepository.get(id);
  }
}
