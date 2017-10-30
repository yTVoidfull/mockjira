package project.management.domain.model.sprint;

import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.issue.Issue;
import org.junit.Test;
import project.management.domain.model.issue.IssueId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SprintTest {

  @Test
  public void canAddAndFindSprintIssue() throws Exception {
    ProjectCode projectCode = new ProjectCode("abcdef123");
    Sprint s = Sprint.of(SprintId.of(projectCode,1));
    Issue i = Issue.of(IssueId.of(projectCode, 1));
    s.add(i);
    assertThat(s.get(IssueId.of(projectCode, 1)).get()).isEqualTo(i);
  }

}
