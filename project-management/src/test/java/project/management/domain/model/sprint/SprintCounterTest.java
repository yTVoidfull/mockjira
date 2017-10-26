package project.management.domain.model.sprint;

import org.junit.Test;
import project.management.domain.model.sprint.SprintCounter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SprintCounterTest {

  @Test
  public void counterIsIncremenetedUponCall() throws Exception {
    SprintCounter counter = new SprintCounter();
    assertThat(counter.getNewId()).isEqualTo(1);
    assertThat(counter.getNewId()).isEqualTo(2);
  }
}
