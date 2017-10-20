package domain.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class InMemoryIssueRepositoryTest {
  
  IssueRepository repo;
  ProjectCode code;

  @Before
  public void setUp(){
    repo = new InMemoryIssueRepository();
    code = new ProjectCode("abcdef123");
  }

  @Test
  public void issueCanrepoeAddedAndFoundInProjectrepoacklog() throws Exception {
    Issue i = Issue.openFor(code, 1);
    repo.add(i);
    assertThat(repo.getIssueBy(IssueId.of(code, 1)).get()).isEqualTo(i);
  }

  @Test
  public void canKnowIssueIsInrepoacklog() throws Exception {
    Issue i = Issue.openFor(code, 1);
    repo.add(i);
    assertThat(repo.contains(i)).isEqualTo(true);
    assertThat(repo.contains(Issue.openFor(code, 2))).isEqualTo(false);
  }

  @Test
  public void cannotAddSameIssueTwice() throws Exception {
    Issue i = Issue.openFor(code, 1);
    repo.add(i);
    Throwable exceptionAddingIssue = catchThrowable(() -> repo.add(i));

    assertThat(exceptionAddingIssue).hasMessage("Issue with given id already present");
  }

  @Test
  public void exceptionThrownWhenAddingNullIssue() throws Exception {
    Throwable exceptionAddingIssue = catchThrowable(() -> repo.add(null));

    assertThat(exceptionAddingIssue).hasMessage("Issue cannot be null");
  }

  @Test
  public void emptyOptionalReturnedWhenNoIssuePresent() throws Exception {
    repo.add(Issue.openFor(code, 1));
    assertThat(repo.getIssueBy(IssueId.of(code, 3))).isEqualTo(Optional.empty());
  }
  
}
