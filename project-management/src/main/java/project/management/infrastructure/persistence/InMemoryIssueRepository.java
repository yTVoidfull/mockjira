package project.management.infrastructure.persistence;

import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.issue.IssueRepository;

import java.util.*;

public class InMemoryIssueRepository implements IssueRepository{

  private Set<Issue> issueSet;

  public InMemoryIssueRepository(){
    this.issueSet = new HashSet<>();
  }

  @Override
  public void add(Issue i) {
    issueSet.add(i);
  }

  @Override
  public Optional<Issue> get(IssueId id){
    return issueSet.stream()
        .filter(issue -> issue.getId().equals(id))
        .findFirst();
  }

  @Override
  public boolean contains(Issue i) {
    return get(i.getId()).isPresent();
  }

  @Override
  public void remove(Issue i) {
    Issue issueToRemove = issueSet.stream()
        .filter(issue -> issue.equals(i))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Cannot remove issue that is not present"));

    issueSet.remove(issueToRemove);
  }

}
