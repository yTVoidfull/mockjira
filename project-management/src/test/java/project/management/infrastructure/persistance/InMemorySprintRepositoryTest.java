package project.management.infrastructure.persistance;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;


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
}
