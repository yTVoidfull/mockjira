package project.management.domain.model.issue;

import java.util.Arrays;
import java.util.Optional;

public enum IssueStatus {

  OPEN("Open", 0),
  IN_REVIEW("In Review", 1),
  IN_DEVELOPMENT("In Development", 2),
  IN_TEST("In Test", 3),
  CLOSED("Closed", 4);

  private String name;
  private int order;

  IssueStatus(String name, int order) {
    this.name = name;
    this.order = order;
  }

  public String getName() {
    return name;
  }

  public static Optional<IssueStatus> valueOf(int i) {
    return Arrays.stream(IssueStatus.values())
        .filter(status -> status.getOrder() == i)
        .findFirst();
  }

  public int getOrder() {
    return order;
  }
}
