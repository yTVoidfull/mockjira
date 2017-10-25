package domain.model.project;

import domain.model.backlog.IssueCounter;
import domain.model.project.OpenProject;
import domain.model.project.ProjectCode;
import domain.model.project.ProjectRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ProjectRepositoryTest {
  private ProjectRepository projectRepository;

  @Before
  public void setUp(){
    projectRepository = new ProjectRepository();
  }

  @Test
  public void aProjectCanBeAddedAndFoundIoTheRepository() throws Exception {
    ProjectCode code = new ProjectCode("abcdef123");
    OpenProject p = new OpenProject(code, new IssueCounter());
    projectRepository.add(p);
    assertThat(projectRepository.get(code)).isEqualTo(Optional.of(p));

  }

  @Test
  public void canKnowThatAProjectIsInRepository() throws Exception {
    ProjectCode code = new ProjectCode("abcdef123");
    ProjectCode code1 = new ProjectCode("abcdef124");
    OpenProject p = new OpenProject(code, new IssueCounter());
    OpenProject p1 = new OpenProject(code1, new IssueCounter());
    projectRepository.add(p);

    assertThat(projectRepository.contains(p)).isEqualTo(true);
    assertThat(projectRepository.contains(p1)).isEqualTo(false);
  }

  @Test
  public void aProjectCannotBeAddedTwice() throws Exception {
    ProjectCode code = new ProjectCode("abcdef123");
    OpenProject p = new OpenProject(code, new IssueCounter());
    projectRepository.add(p);
    Throwable cannotAdd = catchThrowable(() -> projectRepository.add(p));
    assertThat(cannotAdd).hasMessage("Project with this code already exists");
  }

  @Test
  public void exceptionThrownWhenAddingANullProject() throws Exception {
    Throwable cannotAdd = catchThrowable(() -> projectRepository.add(null));
    assertThat(cannotAdd).hasMessage("Project cannot be null");
  }
}
