package domain.model.backlog;

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
