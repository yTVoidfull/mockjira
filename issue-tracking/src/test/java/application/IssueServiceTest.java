package application;

import domain.model.backlog.*;
import infrastructure.persistence.InMemoryIssueRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IssueServiceTest {

    ProjectRepository projectRepository;
    IssueRepository issueRepository;
    IssueService issueService;

    @Before
    public void setUp(){
        projectRepository = new ProjectRepository();
        issueRepository = new InMemoryIssueRepository();
        issueService = new IssueService(projectRepository, issueRepository);
    }

    @Test
    public void canOpenAnIssue() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        projectRepository.add(new OpenProject(projectCode, new IssueCounter()));
        assertThat(issueService.openFor(projectCode).isOpen()).isEqualTo(true);
    }

    @Test
    public void issueIdIsIncrementedInDifferentProjects() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        OpenProject p1 = new OpenProject(projectCode, new IssueCounter());
        projectRepository.add(p1);
        Issue i = issueService.openFor(projectCode);
        Issue i1 = issueService.openFor(projectCode);
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
        assertThat(i1.getIssueId().getId()).isEqualTo(projectCode+"-2");

        ProjectCode otherProjectCode = new ProjectCode("codeBC123");
        OpenProject p2 = new OpenProject(otherProjectCode, new IssueCounter());
        projectRepository.add(p2);
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
