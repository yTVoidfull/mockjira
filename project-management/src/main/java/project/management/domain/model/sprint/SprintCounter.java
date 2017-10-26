package project.management.domain.model.sprint;

public class SprintCounter {
  private int counter;

  public SprintCounter() {
    counter = 1;
  }

  public int getNewId() {
    return counter++;
  }
}
