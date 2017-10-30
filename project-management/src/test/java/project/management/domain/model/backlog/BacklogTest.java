package project.management.domain.model.backlog;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemoryBacklogItemRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BacklogTest {

  Backlog backlog;
  BacklogItemRepository backlogItemRepository;
  SprintRepository sprintRepository;

  @Before
  public void setUp(){
    sprintRepository = new InMemorySprintRepository();
    backlogItemRepository = new InMemoryBacklogItemRepository();
    backlog = new Backlog(backlogItemRepository, sprintRepository);
  }

  @Test
  public void addIssueToBacklog() throws Exception {
    IssueId issueId = IssueId.of(new ProjectCode("abcdef123"), 1);
    Issue i = Issue.of(issueId);
    backlog.add(i);
    backlog.contains(issueId);
  }

  @Test
  public void addSprintToBacklog() throws Exception {
    SprintId sprintId = SprintId.of(new ProjectCode("abcdef123"), 1);
    Sprint sprint = Sprint.of(sprintId);
    backlog.add(sprint);
    assertThat(backlog.contains(sprintId)).isEqualTo(true);
  }

  @Test
  public void removeLastAddedSprint() throws Exception {
    SprintId sprintId = SprintId.of(new ProjectCode("abcdef123"), 1);
    Sprint sprint = Sprint.of(sprintId);
    backlog.add(sprint);
    backlog.remove(sprintId);
    assertThat(backlog.contains(sprintId)).isEqualTo(false);
  }
}
