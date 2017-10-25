package domain.model.backlog;

import domain.model.issue.Issue;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BacklogTest {

  private Backlog backlog;

  @Before
  public void setUp(){
    backlog = new Backlog();
  }

  @Test
  public void issueCanBeAddedAndFound() throws Exception {
    Issue i = Issue.of("id");
    backlog.add(i);
    assertThat(backlog.get("id").get()).isEqualTo(i);
  }

  @Test
  public void canKnowIfIssueIsPresent() throws Exception {
    Issue i = Issue.of("id");
    backlog.add(i);
    assertThat(backlog.contains(i)).isEqualTo(true);
    assertThat(backlog.contains(Issue.of("idd"))).isEqualTo(false);
  }

  @Test
  public void canRemoveIssueAnWithExceptionWhenNoIssuePresent() throws Exception {
    Issue i = Issue.of("id");
    backlog.add(i);
    backlog.remove(Issue.of("id"));
    Throwable exceptionWhileRemoving = catchThrowable(() -> backlog.remove(i));
    assertThat(exceptionWhileRemoving).hasMessage("Cannot remove issue that is not present");
  }


}
