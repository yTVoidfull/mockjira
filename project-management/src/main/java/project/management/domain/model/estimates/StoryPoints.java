package project.management.domain.model.estimates;

import java.util.Objects;

public class StoryPoints {
  private int points;

  public StoryPoints(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }

  public StoryPoints add(StoryPoints storyPoints) {
    return new StoryPoints(points + storyPoints.getPoints());
  }

  public StoryPoints subtract(StoryPoints storyPoints) {
    return new StoryPoints(points - storyPoints.getPoints());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof StoryPoints)) return false;
    StoryPoints that = (StoryPoints) o;
    return points == that.points;
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }
}
