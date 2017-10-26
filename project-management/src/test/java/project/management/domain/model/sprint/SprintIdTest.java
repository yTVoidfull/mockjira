package project.management.domain.model.sprint;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SprintIdTest {

  ProjectCode projectCode;

  @Before
  public void setUp(){
    projectCode = new ProjectCode("abcdef123");
  }

  @Test
  public void SprintIdIsProjectCodeAndSprintId() throws Exception {
    SprintId id = SprintId.of(projectCode, 1);
    assertThat(id.getId()).isEqualTo("abcdef123-s1");
  }

  @Test
  public void sprintIdsAreEqualByTheirId() throws Exception {
    assertThat(SprintId.of(projectCode,1)).isEqualTo(SprintId.of(projectCode,1));
  }
}
