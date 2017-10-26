package project.management.infrastructure.persistence;

import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemorySprintRepository implements SprintRepository {

  private List<Sprint> sprintList;

  public InMemorySprintRepository(){
    sprintList = new ArrayList<>();
  }

  @Override
  public void add(Sprint s) {
    sprintList.add(s);
  }

}
