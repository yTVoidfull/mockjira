package domain.model.backlog;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProjectCodeTest {

  @Test
  public void projectCodeIsAString() throws Exception {
    ProjectCode code = new ProjectCode("string");
    assertThat(code.getProjectCode()).isEqualTo("string");
  }
}
