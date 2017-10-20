package domain.model;

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

  public Optional<Issue> getIssueBy(IssueId id) {
    for(Issue i : issues){
      if(i.getIssueId().equals(id)){
        return Optional.of(i);
      }
    }
    return Optional.empty();
  }

  public boolean contains(Issue issue) {
    return issues.contains(issue);
  }
}
