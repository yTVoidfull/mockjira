package project.management.domain.services.issue;

import org.junit.Test;
import project.management.domain.model.issue.IssueStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ReviewToDevelopmentTest {

  @Test
  public void canMoveFromReviewToDevelopment() throws Exception {
    assertThat(new ReviewToDevelopment().invokeOn(IssueStatus.IN_REVIEW)).isEqualTo(IssueStatus.IN_DEVELOPMENT);
  }

  @Test
  public void exceptionThrownWhenMovingFromUnacceptedStatus() throws Exception {
    Throwable ex = catchThrowable(() -> new ReviewToDevelopment().invokeOn(IssueStatus.CLOSED));
    assertThat(ex).hasMessage("Cannot change to In Development from Closed");
  }
}
