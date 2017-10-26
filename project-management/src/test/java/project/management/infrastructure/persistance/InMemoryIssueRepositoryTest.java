package project.management.infrastructure.persistance;

import project.management.domain.model.ProjectCode;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.infrastructure.persistence.InMemoryIssueRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class InMemoryIssueRepositoryTest {

  private InMemoryIssueRepository inMemoryIssueRepository;
  ProjectCode projectCode = new ProjectCode("abcdef123");

  @Before
  public void setUp(){
    inMemoryIssueRepository = new InMemoryIssueRepository();
  }

  @Test
  public void issueCanBeAddedAndFound() throws Exception {
    IssueId id = IssueId.of(projectCode, 1);
    Issue i = Issue.of(id);
    inMemoryIssueRepository.add(i);
    assertThat(inMemoryIssueRepository.get(id).get()).isEqualTo(i);
  }

  @Test
  public void canKnowIfIssueIsPresent() throws Exception {
    IssueId id = IssueId.of(projectCode, 1);
    Issue i = Issue.of(id);
    inMemoryIssueRepository.add(i);
    assertThat(inMemoryIssueRepository.contains(i)).isEqualTo(true);
    assertThat(inMemoryIssueRepository.contains(Issue.of(IssueId.of(projectCode, 2)))).isEqualTo(false);
  }

  @Test
  public void canRemoveIssueAnWithExceptionWhenNoIssuePresent() throws Exception {
    IssueId id = IssueId.of(projectCode, 1);
    Issue i = Issue.of(id);
    inMemoryIssueRepository.add(i);
    inMemoryIssueRepository.remove(Issue.of(id));
    Throwable exceptionWhileRemoving = catchThrowable(() -> inMemoryIssueRepository.remove(i));
    assertThat(exceptionWhileRemoving).hasMessage("Cannot remove issue that is not present");
  }

}
