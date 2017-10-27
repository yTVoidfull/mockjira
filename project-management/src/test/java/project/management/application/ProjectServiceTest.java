package project.management.application;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueRepository;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemoryIssueRepository;
import project.management.infrastructure.persistence.InMemoryProjectRepository;
import project.management.domain.model.Project;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.ProjectRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import project.management.application.ProjectService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ProjectServiceTest {
    private ProjectService pService;
    private Backlog backlog;

    @Before
    public void aServiceWillBeAvailableForAClient(){
        ProjectRepository repo = new InMemoryProjectRepository();
        pService = new ProjectService(repo);
        backlog = new Backlog(null, null);
    }

    @Test
    public void canCreateANewProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        Project p = pService.create(pCode, backlog);
        Assertions.assertThat(p.getCode()).isEqualTo(pCode);
    }

    @Test
    public void canFindAProjectByCode() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        ProjectCode pCode1 = new ProjectCode("abcdBD123");
        pService.create(pCode, backlog);
        Project p1 = pService.create(pCode1, backlog);
        Assertions.assertThat(pService.get(pCode1)).isEqualTo(Optional.of(p1));
    }

    @Test
    public void nullIsReturnedWhenThereIsNoSuchProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode, backlog);
        Assertions.assertThat(pService.get(new ProjectCode("abcdef123"))).isEqualTo(Optional.empty());
    }

    @Test
    public void aProjectCanBeClosed() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode, backlog);
        pService.close(pCode);
        Assertions.assertThat(((Project)pService.get(pCode).get()).isOpen()).isEqualTo(false);
    }

    @Test
    public void projectCodeIsUnique() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode, backlog);
        Throwable illegalArgument = catchThrowable(() -> pService.create(pCode, backlog));
        assertThat(illegalArgument).hasMessage("Project with this code already exists");
    }

    @Test
    public void exceptionThrownWhenClosingNonExistentProject() throws Exception {
        Throwable ex = catchThrowable(() -> pService.close(new ProjectCode("xyzuvw123")));
        assertThat(ex).hasMessage("There is no project with given code");
    }
}
