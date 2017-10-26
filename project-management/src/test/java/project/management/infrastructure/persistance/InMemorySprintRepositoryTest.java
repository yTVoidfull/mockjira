package project.management.infrastructure.persistance;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


public class InMemorySprintRepositoryTest {

  SprintRepository sprintRepository;
  ProjectCode projectCode;

  @Before
  public void setUp(){
    sprintRepository = new InMemorySprintRepository();
    projectCode = new ProjectCode("abcdef123");
  }

  @Test
  public void sprintsCanBeAddedAndFound() throws Exception {
    SprintId id = SprintId.of(projectCode, 1);
    sprintRepository.add(Sprint.of(id));
  }

  @Test
  public void sprintCanBeRemoved() throws Exception {
    SprintId id = SprintId.of(projectCode, 1);
    sprintRepository.remove(id);
    assertThat(sprintRepository.contains(SprintId.of(projectCode, 1))).isEqualTo(false);
  }

  @Test
  public void sprintCanBeFound() throws Exception {
    SprintId id = SprintId.of(projectCode, 1);
    sprintRepository.add(Sprint.of(id));
    Optional<Sprint> s = sprintRepository.get(id);
    assertThat(s.get()).isEqualTo(Sprint.of(id));
  }

  @Test
  public void exceptionThrownWhenAddingANullSprint() throws Exception {
    Throwable exceptionNullAdd = catchThrowable(() -> sprintRepository.add(null));
    assertThat(exceptionNullAdd).hasMessage("Cannot add null sprint");
  }

  @Test
  public void exceptionThrownWhenLookingUpWithNullId() throws Exception {
    Throwable exceptionNullLookUp = catchThrowable(() -> sprintRepository.contains(null));
    assertThat(exceptionNullLookUp).hasMessage("Cannot look up with null id");
  }

  @Test
  public void exceptionThrownWhenRemovingWithNullId() throws Exception {
    Throwable exceptionNullRemove = catchThrowable(() -> sprintRepository.remove(null));
    assertThat(exceptionNullRemove).hasMessage("Cannot remove with null id");
  }
}
