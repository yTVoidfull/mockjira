package application;

import domain.model.Project;
import domain.model.ProjectCode;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ProjectServiceTest {
    ProjectService pService;

    @Before
    public void aServiceWillBeAvailableForAClient(){
        pService = new ProjectService();

    }

    @Test
    public void canCreateANewProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        Project p = pService.create(pCode);
        assertThat(p.getCode()).isEqualTo(pCode);
    }

    @Test
    public void canFindAProjectByCode() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        ProjectCode pCode1 = new ProjectCode("abcdBD123");
        pService.create(pCode);
        Project p1 = pService.create(pCode1);
        assertThat(pService.find(pCode1)).isEqualTo(p1);
    }

    @Test
    public void nullIsReturnedWhenThereIsNoSuchProject() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        assertThat(pService.find(new ProjectCode("abcdef123"))).isEqualTo(null);
    }

    @Test
    public void aProjectCanBeClosed() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        pService.close(pCode);
        assertThat(pService.find(pCode).isOpen()).isEqualTo(false);
    }

    @Test
    public void projectCodeIsUnique() throws Exception {
        ProjectCode pCode = new ProjectCode("abcdEF123");
        pService.create(pCode);
        Throwable illegalArgument = catchThrowable(() -> pService.create(pCode));
        assertThat(illegalArgument).hasMessage("Project with this code already exists");
    }
}
