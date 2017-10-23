package application;

import domain.model.InMemoryProjectRepository;
import domain.model.Project;
import domain.model.ProjectCode;
import domain.model.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ProjectServiceTest {
    ProjectService pService;

    @Before
    public void aServiceWillBeAvailableForAClient(){
        ProjectRepository repo = new InMemoryProjectRepository();
        pService = new ProjectService(repo);

    }

    @Test
    public void canCreateANewProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        Project p = pService.create(pCode);
        Assertions.assertThat(p.getCode()).isEqualTo(pCode);
    }

    @Test
    public void canFindAProjectByCode() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        ProjectCode pCode1 = new ProjectCode("abcdBD123");
        pService.create(pCode);
        Project p1 = pService.create(pCode1);
        Assertions.assertThat(pService.get(pCode1)).isEqualTo(Optional.of(p1));
    }

    @Test
    public void nullIsReturnedWhenThereIsNoSuchProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        Assertions.assertThat(pService.get(new ProjectCode("abcdef123"))).isEqualTo(Optional.empty());
    }

    @Test
    public void aProjectCanBeClosed() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        pService.close(pCode);
        Assertions.assertThat(((Project)pService.get(pCode).get()).isOpen()).isEqualTo(false);
    }

    @Test
    public void projectCodeIsUnique() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        Throwable illegalArgument = catchThrowable(() -> pService.create(pCode));
        assertThat(illegalArgument).hasMessage("Project with this code already exists");
    }

    @Test
    public void exceptionThrownWhenClosingNonExistentProject() throws Exception {
        Throwable ex = catchThrowable(() -> pService.close(new ProjectCode("xyzuvw123")));
        assertThat(ex).hasMessage("There is no project with given code");
    }
}
