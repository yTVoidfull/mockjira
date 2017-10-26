package project.management.domain.model;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.issue.IssueRepository;
import project.management.domain.model.sprint.SprintCounter;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemoryIssueRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ProjectTest {

    Project p;

    @Before
    public void setUp(){
        IssueRepository issueRepository = new InMemoryIssueRepository();
        SprintRepository sprintRepository = new InMemorySprintRepository();
        p = new Project(new ProjectCode("codeAB123"), new Backlog(issueRepository, sprintRepository), new IssueCounter(), new SprintCounter());

    }

    @Test
    public void canOpen() throws Exception {
        assertThat(p.getCode().toString()).isEqualTo("codeAB123");
        assertThat(p.isOpen()).isEqualTo(true);
    }

    @Test
    public void canBeClosed() throws Exception {
        p.close();
        assertThat(p.isOpen()).isEqualTo(false);
    }

    @Test
    public void projectHasBacklog() throws Exception {
        Backlog pBacklog = p.getBacklog();
        assertThat(pBacklog).isNotNull();
    }

    @Test
    public void openedIssuesAreAddedToBacklog() throws Exception {
        p.openIssue();
        Backlog pBacklog = p.getBacklog();
        assertThat(pBacklog.get(IssueId.of(p.getCode(), 1))).isNotEmpty();
    }

}