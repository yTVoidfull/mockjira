package project.management.domain.services.issue;

import org.junit.Test;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.project.ProjectCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class DevelopmentToTestTest {

  @Test
  public void issueCanTransitionStatusFromInDevelopmentToInTest() throws Exception {
    Issue i = Issue.of(IssueId.of(new ProjectCode("abdcef123"), 1));
    i.changeStatus(new OpenToReview());
    i.changeStatus(new ReviewToDevelopment());
    i.changeStatus(new DevelopmentToTest());
    assertThat(i.getStatus()).isEqualTo(IssueStatus.IN_TEST);
  }

  @Test
  public void exceptionThrownWhenMovingFromUnacceptableStatul() throws Exception {
    Issue i = Issue.of(IssueId.of(new ProjectCode("abcdef123"), 1));
    Throwable exceptionWrongStatus = catchThrowable(() -> i.changeStatus(new DevelopmentToTest()));
    assertThat(exceptionWrongStatus).hasMessage("Cannot change to In Test from Open");
  }
}
