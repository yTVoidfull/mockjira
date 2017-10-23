package infrastructure.persistence;

import domain.model.backlog.Issue;
import domain.model.backlog.IssueId;
import domain.model.backlog.IssueRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryIssueRepository implements IssueRepository {

  private Set<Issue> issues = new HashSet<>();

  public InMemoryIssueRepository() {
  }

  public void add(Issue i) {
    if(i == null){
      throw new IllegalStateException("Issue cannot be null");
    }
    if(issues.contains(i)){
      throw new IllegalStateException("Issue with given id already present");
    }
    issues.add(i);
  }

  public Optional<Issue> get(IssueId id) {
    return issues.stream()
        .filter(i -> i.getIssueId().equals(id))
        .findFirst();
  }

  public boolean contains(Issue issue) {
    return issues.contains(issue);
  }
}
