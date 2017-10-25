package domain.model.issue;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IssueTest {

  @Test
  public void issueCreatedIsOpen() throws Exception {
    Issue i = Issue.of("id");
    assertThat(i.isOpen()).isEqualTo(true);
  }

  @Test
  public void canBeClosed() throws Exception {
    Issue i = Issue.of("id");
    i.close();
    assertThat(i.isOpen()).isEqualTo(false);
  }
}
