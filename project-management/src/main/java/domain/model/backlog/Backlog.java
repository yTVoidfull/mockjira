package domain.model.backlog;

import domain.model.issue.Issue;
import domain.model.sprint.Sprint;

import java.util.*;

public class Backlog {

  private Set<Issue> issueSet;
  private List<Sprint> sprintList;

  public Backlog(){
    this.issueSet = new HashSet<>();
    this.sprintList = new ArrayList<>();
  }

  public void add(Issue i) {
    issueSet.add(i);
  }

  public Optional<Issue> get(String id){
    return issueSet.stream()
        .filter(issue -> issue.getId().equals(id))
        .findFirst();
  }

  public boolean contains(Issue i) {
    return get(i.getId()).isPresent();
  }

  public void remove(Issue i) {
    Issue issueToRemove = issueSet.stream()
        .filter(issue -> issue.equals(i))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Cannot remove issue that is not present"));

    issueSet.remove(issueToRemove);
  }


}
