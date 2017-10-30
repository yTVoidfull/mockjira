package project.management.domain.services.issue;

import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.issue.IssueStatusModifier;

public class OpenToReview implements IssueStatusModifier {

  public final IssueStatus fromStatus = IssueStatus.OPEN;

  @Override
  public IssueStatus invokeOn(IssueStatus status) {
    if(status == fromStatus) {
      return IssueStatus.IN_REVIEW;
    }
    throw new IllegalStateException("Cannot change to In Review from "+ status.getName());
  }

}
