package project.management.infrastructure.persistance;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.backlog.BacklogItem;
import project.management.domain.model.backlog.BacklogItemRepository;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.user.Username;
import project.management.infrastructure.persistence.InMemoryBacklogItemRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class InMemoryBacklogItemRepositoryTest {

  private BacklogItemRepository inMemoryIssueRepository;
  ProjectCode projectCode = new ProjectCode("abcdef123");

  @Before
  public void setUp(){
    inMemoryIssueRepository = new InMemoryBacklogItemRepository();
    projectCode = new ProjectCode("abcdef123");
  }

  @Test
  public void backlogItemCanBeAddedAndFound() throws Exception {
    IssueId issueId = IssueId.of(projectCode, 1);
    BacklogItem backlogItem = new BacklogItem(issueId, "name", new Username("username"), 3);
    inMemoryIssueRepository.add(backlogItem);
    assertThat(inMemoryIssueRepository.get(issueId).get()).isEqualTo(backlogItem);
  }

  @Test
  public void canKnowIfBacklogItemIsPresent() throws Exception {
    IssueId issueId = IssueId.of(projectCode, 1);
    BacklogItem backlogItem = new BacklogItem(issueId, "name", new Username("username"), 3);
    inMemoryIssueRepository.add(backlogItem);
    assertThat(inMemoryIssueRepository.contains(issueId)).isEqualTo(true);
  }

  @Test
  public void canRemoveBacklogItemAnWithExceptionWhenNoIssuePresent() throws Exception {
    IssueId issueId = IssueId.of(projectCode, 1);
    BacklogItem backlogItem = new BacklogItem(issueId, "name", new Username("username"), 3);
    inMemoryIssueRepository.add(backlogItem);
    inMemoryIssueRepository.remove(issueId);
    assertThat(inMemoryIssueRepository.contains(issueId)).isEqualTo(false);
  }
}
