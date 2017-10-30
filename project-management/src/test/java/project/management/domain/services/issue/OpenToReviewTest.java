package project.management.domain.services.issue;

import org.junit.Test;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.project.ProjectCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class OpenToReviewTest {

  @Test
  public void issueCanTransitionStatusFromOpenToInReview() throws Exception {
    Issue i = Issue.of(IssueId.of(new ProjectCode("abdcef123"), 1));
    i.changeStatus(new OpenToReview());
    assertThat(i.getStatus()).isEqualTo(IssueStatus.IN_REVIEW);
  }

  @Test
  public void exceptionThrownWhenMovingFromUnacceptableStatul() throws Exception {
    Issue i = Issue.of(IssueId.of(new ProjectCode("abcdef123"), 1));
    i.changeStatus(new OpenToReview());
    Throwable exceptionWrongStatus = catchThrowable(() -> i.changeStatus(new OpenToReview()));
    assertThat(exceptionWrongStatus).hasMessage("Cannot change to In Review from In Review");
  }
}
