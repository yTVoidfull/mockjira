package infrastructure.persistance;

import domain.model.backlog.Backlog;
import domain.model.issue.IssueCounter;
import domain.model.Project;
import domain.model.ProjectCode;
import domain.model.sprint.SprintCounter;
import infrastructure.persistence.InMemoryProjectRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InMemoryProjectRepositoryTest {

    private InMemoryProjectRepository repo;

    @Before
    public void setUp(){
        repo = new InMemoryProjectRepository();
    }

    @Test
    public void aProjectCanBeAddedAndFoundIoTheRepository() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        Project p = new Project(code, new Backlog(), new IssueCounter(), new SprintCounter());
        repo.add(p);
        assertThat(repo.get(code)).isEqualTo(Optional.of(p));

    }

    @Test
    public void canKnowThatAProjectIsInRepository() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        ProjectCode code1 = new ProjectCode("abcdef124");
        Project p = new Project(code, new Backlog(), new IssueCounter(), new SprintCounter());
        Project p1 = new Project(code1, new Backlog(), new IssueCounter(), new SprintCounter());
        repo.add(p);

        assertThat(repo.contains(p)).isEqualTo(true);
        assertThat(repo.contains(p1)).isEqualTo(false);
    }

    @Test
    public void aProjectCannotBeAddedTwice() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        Project p = new Project(code, new Backlog(), new IssueCounter(), new SprintCounter());
        repo.add(p);
        Throwable cannotAdd = catchThrowable(() -> repo.add(p));
        assertThat(cannotAdd).hasMessage("Project with this code already exists");
    }

    @Test
    public void exceptionThrownWhenAddingANullProject() throws Exception {
        Throwable cannotAdd = catchThrowable(() -> repo.add(null));
        assertThat(cannotAdd).hasMessage("Project cannot be null");
    }
}
