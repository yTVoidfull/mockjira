package project.management.domain.model.issue;

import project.management.domain.model.issue.IssueCounter;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IssueCounterTest {

  @Test
  public void theCounterIsIncrementedAtEachCall() throws Exception {
    IssueCounter counter = new IssueCounter();
    assertThat(counter.getANewId()).isEqualTo(1);
    assertThat(counter.getANewId()).isEqualTo(2);
  }

}
