package project.management.domain.model.issue;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IssueStatusTest {

  @Test
  public void canGetStatusByOrder() throws Exception {
    IssueStatus status = IssueStatus.valueOf(0).get();
    assertThat(status.getOrder()).isEqualTo(0);
    assertThat(status.getName()).isEqualTo("Open");
  }
}
