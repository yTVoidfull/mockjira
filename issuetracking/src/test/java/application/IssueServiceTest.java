package application;

import domain.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IssueServiceTest {

    ProjectRepository repo;
    IssueCounter issueCounter;
    IssueService issueService;

    @Before
    public void setUp(){
        repo = new InMemoryProjectRepository();
        issueCounter = new IssueCounter();
        issueService = new IssueService(issueCounter, repo);
    }

    @Test
    public void canOpenAnIssue() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        repo.add(new Project(projectCode));
        assertThat(issueService.openFor(projectCode).isOpen()).isEqualTo(true);
    }

    @Test
    public void exceptionThrownIfOpeningAnIssueWhenClosed() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        Project p = new Project(projectCode);
        p.close();
        repo.add(p);
        Throwable exceptionWhenOpeningIssueFromClosedProject = catchThrowable(() -> issueService.openFor(projectCode));
        assertThat(exceptionWhenOpeningIssueFromClosedProject.getMessage()).isEqualTo("Issues must be created only in ongoing projects");
    }

    @Test
    public void issueIdIsIncrementedInDifferentProjects() throws Exception {

        ProjectCode projectCode = new ProjectCode("codeAB123");
        Project p1 = new Project(projectCode);
        repo.add(p1);
        Issue i = issueService.openFor(projectCode);
        Issue i1 = issueService.openFor(projectCode);
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
        assertThat(i1.getIssueId().getId()).isEqualTo(projectCode+"-2");

        ProjectCode otherProjectCode = new ProjectCode("codeBC123");
        Project p2 = new Project(otherProjectCode);
        repo.add(p2);
        Issue i3 = issueService.openFor(otherProjectCode);
        Issue i4 = issueService.openFor(otherProjectCode);
        assertThat(i3.getIssueId().getId()).isEqualTo(otherProjectCode+"-1");
        assertThat(i4.getIssueId().getId()).isEqualTo(otherProjectCode+"-2");
    }

    @Test
    public void exceptionThrownWhenOpeningIssueForInexistentProject() throws Exception {
        Throwable exception = catchThrowable(() -> issueService.openFor(new ProjectCode("codeAB123")));
        assertThat(exception).hasMessage("Issues must be created for existing projects");
    }
}
