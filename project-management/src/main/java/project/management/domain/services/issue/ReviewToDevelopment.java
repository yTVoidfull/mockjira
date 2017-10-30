package project.management.domain.services.issue;

import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.issue.IssueStatusModifier;

public class ReviewToDevelopment implements IssueStatusModifier {

  private final IssueStatus fromStatus = IssueStatus.IN_REVIEW;

  @Override
  public IssueStatus invokeOn(IssueStatus status) {
    if(status == fromStatus) {
      return IssueStatus.IN_DEVELOPMENT;
    }
    throw new IllegalStateException("Cannot change to In Development from "+ status.getName());
  }
}
