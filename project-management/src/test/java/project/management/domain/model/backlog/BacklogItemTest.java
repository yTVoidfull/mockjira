package project.management.domain.model.backlog;

import org.junit.Test;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.user.Username;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BacklogItemTest {

  @Test
  public void backlogItemHasIdNameUserAndStoryPoints() throws Exception {
    IssueId issueId = IssueId.of(new ProjectCode("abcdef123"), 1);
    BacklogItem backlogItem = new BacklogItem(issueId, "name", new Username("username"), 3);
    assertThat(backlogItem.getId()).isEqualTo(issueId);
    assertThat(backlogItem.getName()).isEqualTo("name");
    assertThat(backlogItem.getUsername().getUsername()).isEqualTo("username");
    assertThat(backlogItem.getStoryPoints()).isEqualTo(3);
  }

}
