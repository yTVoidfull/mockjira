package project.management.infrastructure.persistence;

import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemorySprintRepository implements SprintRepository {

  private List<Sprint> sprintList;

  public InMemorySprintRepository(){
    sprintList = new ArrayList<>();
  }

  @Override
  public void add(Sprint s) {
    if(s == null){
      throw new IllegalStateException("Cannot add null sprint");
    }
    sprintList.add(s);
  }

  @Override
  public void remove(SprintId id) {
    if(id == null){
      throw new IllegalStateException("Cannot remove with null id");
    }
    sprintList.removeIf(sprint -> sprint.getId().equals(id));
  }

  @Override
  public boolean contains(SprintId id) {
    if(id == null){
      throw new IllegalStateException("Cannot look up with null id");
    }
    return sprintList.stream()
        .anyMatch(sprint -> sprint.getId().equals(id));
  }

  @Override
  public Optional<Sprint> get(SprintId id) {
    return sprintList.stream()
        .filter(sprint -> sprint.getId().equals(id))
        .findAny();
  }

}
