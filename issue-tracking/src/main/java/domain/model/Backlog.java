package domain.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Backlog {

  private final Project project;
  private Set<IssueId> issueIdSet = new HashSet<>();


  public Backlog(Project project) {
    this.project = project;
  }

  public void add(IssueId issueId) {
    if(issueId == null){
      throw new IllegalStateException("IssueId cannot be null");
    }
    if(issueIdSet.contains(issueId)){
      throw new IllegalStateException("IssueId already present");
    }
    issueIdSet.add(issueId);
  }

  public IssueId getIssueId(String i) {
    for(IssueId id : issueIdSet){
      if(id.getId().equals(i)){
        return id;
      }
    }
    throw new IllegalStateException("There is no issue with given id");
  }
}
