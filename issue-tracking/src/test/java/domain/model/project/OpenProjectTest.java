package domain.model.project;

import domain.model.backlog.IssueCounter;
import domain.model.project.OpenProject;
import domain.model.project.ProjectCode;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OpenProjectTest {

  @Test
  public void projectHasProjectCode() throws Exception {
    ProjectCode code = new ProjectCode("code");
    OpenProject p = new OpenProject(code, new IssueCounter());
    assertThat(p.getCode()).isEqualTo(code);
  }
}
