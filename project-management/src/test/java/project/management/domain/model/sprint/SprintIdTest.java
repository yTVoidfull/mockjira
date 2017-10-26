package project.management.domain.model.sprint;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SprintIdTest {

  @Test
  public void SprintIdIsProjectCodeAndSprintId() throws Exception {
    ProjectCode projectCode = new ProjectCode("abcdef123");
    SprintId id = SprintId.of(projectCode, 1);
    assertThat(id.getId()).isEqualTo("abcdef123-s1");
  }
}
