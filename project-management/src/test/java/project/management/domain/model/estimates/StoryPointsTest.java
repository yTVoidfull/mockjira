package project.management.domain.model.estimates;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StoryPointsTest {

  @Test
  public void twoStorypointsCanBeAdded() throws Exception {
    StoryPoints s1 = new StoryPoints(3);
    StoryPoints s2 = new StoryPoints(5);

    assertThat(s1.add(s2).getPoints()).isEqualTo(8);
  }

  @Test
  public void twoStoryPointsCanBeSubtracted() throws Exception {
    StoryPoints s1 = new StoryPoints(3);
    StoryPoints s2 = new StoryPoints(5);

    assertThat(s2.hashCode()).isEqualTo(new StoryPoints(5).hashCode());
    assertThat(s2.subtract(s1)).isEqualTo(new StoryPoints(2));
  }
}
