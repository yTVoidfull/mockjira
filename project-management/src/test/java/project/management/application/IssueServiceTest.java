package project.management.application;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.issue.IssueStatus;
import project.management.domain.model.project.OpenProject;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.project.ProjectRepository;
import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.backlog.BacklogItemRepository;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.IssueRepository;
import project.management.domain.model.sprint.SprintCounter;
import project.management.domain.model.sprint.SprintRepository;
import project.management.domain.services.issue.ReviewToDevelopment;
import project.management.domain.services.issue.OpenToReview;
import project.management.infrastructure.persistence.InMemoryBacklogItemRepository;
import project.management.infrastructure.persistence.InMemoryIssueRepository;
import project.management.infrastructure.persistence.InMemoryProjectRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IssueServiceTest {

    ProjectRepository projectRepository;
    IssueRepository issueRepository;
    Backlog backlog;
    IssueService issueService;
    BacklogItemRepository backlogItemRepository;

    @Before
    public void setUp(){
        projectRepository = new InMemoryProjectRepository();
        issueRepository = new InMemoryIssueRepository();
        issueService = new IssueService(projectRepository, issueRepository);
        backlogItemRepository = new InMemoryBacklogItemRepository();
        SprintRepository sprintRepository = new InMemorySprintRepository();
        backlog = new Backlog(backlogItemRepository, sprintRepository);
    }

    @Test
    public void canOpenAnIssue() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        projectRepository.add(new OpenProject(projectCode,backlog, new IssueCounter(), new SprintCounter()));
        assertThat(issueService.openFor(projectCode).getStatus()).isEqualTo(IssueStatus.OPEN);
    }

    @Test
    public void issueIdIsIncrementedInDifferentProjects() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        OpenProject p1 = new OpenProject(projectCode,backlog, new IssueCounter(), new SprintCounter());
        projectRepository.add(p1);
        Issue i = issueService.openFor(projectCode);
        Issue i1 = issueService.openFor(projectCode);
        assertThat(i.getId().getId()).isEqualTo(projectCode+"-1");
        assertThat(i1.getId().getId()).isEqualTo(projectCode+"-2");

        ProjectCode otherProjectCode = new ProjectCode("codeBC123");
        OpenProject p2 = new OpenProject(otherProjectCode, backlog, new IssueCounter(), new SprintCounter());
        projectRepository.add(p2);
        Issue i3 = issueService.openFor(otherProjectCode);
        Issue i4 = issueService.openFor(otherProjectCode);
        assertThat(i3.getId().getId()).isEqualTo(otherProjectCode+"-1");
        assertThat(i4.getId().getId()).isEqualTo(otherProjectCode+"-2");
    }

    @Test
    public void exceptionThrownWhenOpeningIssueForInexistentProject() throws Exception {
        Throwable exception = catchThrowable(() -> issueService.openFor(new ProjectCode("codeAB123")));
        assertThat(exception).hasMessage("Issues must be created for existing projects");
    }

    @Test
    public void moveIssueFromInReviewToInDevelopment() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        OpenProject p1 = new OpenProject(projectCode,backlog, new IssueCounter(), new SprintCounter());
        projectRepository.add(p1);
        Issue i1 = issueService.openFor(projectCode);
        i1.changeStatus(new OpenToReview());
        i1.changeStatus(new ReviewToDevelopment());
        assertThat(i1.getStatus()).isEqualTo(IssueStatus.IN_DEVELOPMENT);
    }
}
