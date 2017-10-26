package project.management.domain.model.sprint;

import java.util.Optional;

public interface SprintRepository {

  void add(Sprint s);

  void remove(SprintId id);

  boolean contains(SprintId id);

  Optional<Sprint> get(SprintId id);
}
