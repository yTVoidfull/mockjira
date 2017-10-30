package project.management.infrastructure.persistance;

import project.management.domain.model.project.OpenProject;
import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.sprint.SprintCounter;
import project.management.infrastructure.persistence.InMemoryProjectRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InMemoryOpenProjectRepositoryTest {

    private InMemoryProjectRepository repo;
    private Backlog backlog;

    @Before
    public void setUp(){
        repo = new InMemoryProjectRepository();
        backlog = new Backlog(null, null);
    }

    @Test
    public void aProjectCanBeAddedAndFoundIoTheRepository() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        OpenProject p = new OpenProject(code, backlog, new IssueCounter(), new SprintCounter());
        repo.add(p);
        assertThat(repo.get(code)).isEqualTo(Optional.of(p));

    }

    @Test
    public void canKnowThatAProjectIsInRepository() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        ProjectCode code1 = new ProjectCode("abcdef124");
        OpenProject p = new OpenProject(code, backlog, new IssueCounter(), new SprintCounter());
        OpenProject p1 = new OpenProject(code1, backlog, new IssueCounter(), new SprintCounter());
        repo.add(p);

        assertThat(repo.contains(p)).isEqualTo(true);
        assertThat(repo.contains(p1)).isEqualTo(false);
    }

    @Test
    public void aProjectCannotBeAddedTwice() throws Exception {
        ProjectCode code = new ProjectCode("abcdef123");
        OpenProject p = new OpenProject(code, backlog, new IssueCounter(), new SprintCounter());
        repo.add(p);
        Throwable cannotAdd = catchThrowable(() -> repo.add(p));
        assertThat(cannotAdd).hasMessage("OpenProject with this code already exists");
    }

    @Test
    public void exceptionThrownWhenAddingANullProject() throws Exception {
        Throwable cannotAdd = catchThrowable(() -> repo.add(null));
        assertThat(cannotAdd).hasMessage("OpenProject cannot be null");
    }
}
