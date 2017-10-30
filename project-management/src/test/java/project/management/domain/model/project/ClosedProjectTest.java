package project.management.domain.model.project;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClosedProjectTest {

  @Test
  public void closedProjectHasProjectCode() throws Exception {
    ClosedProject closedProject = new ClosedProject(new ProjectCode("abcdef123"));
    assertThat(closedProject.getProjectCode()).isEqualTo(new ProjectCode("abcdef123"));
  }
}
