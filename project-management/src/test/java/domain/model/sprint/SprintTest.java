package domain.model.sprint;

import domain.model.issue.Issue;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SprintTest {

  @Test
  public void canAddAndFindSprintIssue() throws Exception {
    Sprint s = Sprint.of(1);
    s.add(Issue.of("id"));
    assertThat(s.get("id").get()).isEqualTo(Issue.of("id"));
  }

  @Test
  public void sprintHasAnumericalId() throws Exception {
    Sprint s = Sprint.of(1);
    assertThat(s.getId()).isEqualTo(1);
  }
}
