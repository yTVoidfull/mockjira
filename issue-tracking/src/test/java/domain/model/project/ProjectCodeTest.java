package domain.model.project;

import domain.model.project.ProjectCode;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProjectCodeTest {

  @Test
  public void projectCodeIsAString() throws Exception {
    ProjectCode code = new ProjectCode("string");
    assertThat(code.getProjectCode()).isEqualTo("string");
  }
}
