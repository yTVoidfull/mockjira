package project.management.domain.services.issue;

import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.issue.IssueStatusModifier;

public class DevelopmentToTest implements IssueStatusModifier{

  public final IssueStatus fromStatus = IssueStatus.IN_DEVELOPMENT;

  @Override
  public IssueStatus invokeOn(IssueStatus status) {
    if(status == fromStatus) {
      return IssueStatus.IN_TEST;
    }
    throw new IllegalStateException("Cannot change to In Test from "+ status.getName());
  }
}
