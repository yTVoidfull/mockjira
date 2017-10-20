package domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BacklogTest {

  ProjectCode code;
  Backlog b;

  @Before
  public void setUp(){
    code = new ProjectCode("abcdef123");
    Project p = new Project(code);
    b = new Backlog(p);
  }

  @Test
  public void issueIdCanBeAddedAndFoundInBacklog() throws Exception {
    b.add(IssueId.of(code, 1));
    assertThat(b.getIssueId("abcdef123-1")).isEqualTo(IssueId.of(code,1));
  }

  @Test
  public void exceptionThrownWhenThereIsNoIssue() throws Exception {
    b.add(IssueId.of(code, 1));
    Throwable noIssueFound = catchThrowable(() -> b.getIssueId("abcdef123-2"));
    assertThat(noIssueFound).hasMessage("There is no issue with given id");
  }

  @Test
  public void exceptionThrownWhenAddingSameIssue() throws Exception {
    b.add(IssueId.of(code, 1));
    Throwable cannotAddSameIssue = catchThrowable(() -> b.add(IssueId.of(code, 1)));
    assertThat(cannotAddSameIssue).hasMessage("IssueId already present");
  }

  @Test
  public void exceptionWhenAddingNullIssueId() throws Exception {
    Throwable cannotAddNullIssueId = catchThrowable(() -> b.add(null));
    assertThat(cannotAddNullIssueId).hasMessage("IssueId cannot be null");
  }
}
