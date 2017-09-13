package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by alplesca on 9/4/2017.
 */
public class ProjectTest {

    @Test
    public void canOpen() throws Exception {
        Project p = new Project("codeAB123");
        assertThat(p.getCode().toString()).isEqualTo("codeAB123");
        assertThat(p.isOpen()).isEqualTo(true);
    }

    @Test
    public void canBeClosed() throws Exception {
        Project p = new Project("codeAB123");
        p.close();
        assertThat(p.isOpen()).isEqualTo(false);
    }

    @Test
    public void canOpenAnIssue() throws Exception {
        Project p = new Project("codeAB123");
        Issue i = p.openIssue();
        assertThat(i.isOpen()).isEqualTo(true);
    }

    @Test
    public void exceptionThrownIfOpeningAnIssueWhenClosed() throws Exception {
        Project p = new Project("codeAB123");
        p.close();
        Throwable exceptionWhenOpeningIssueFromClosedProject = catchThrowable(p::openIssue);
        assertThat(exceptionWhenOpeningIssueFromClosedProject.getMessage()).isEqualTo("Issues must be created only in ongoing projects");
    }

}
