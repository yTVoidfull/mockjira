package project.management.domain.model.project;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.backlog.BacklogItemRepository;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.sprint.SprintCounter;
import project.management.domain.model.sprint.SprintId;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemoryBacklogItemRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class OpenProjectTest {

    OpenProject p;

    @Before
    public void setUp(){
        BacklogItemRepository backlogItemRepository = new InMemoryBacklogItemRepository();
        SprintRepository sprintRepository = new InMemorySprintRepository();
        p = new OpenProject(new ProjectCode("codeAB123"), new Backlog(backlogItemRepository, sprintRepository), new IssueCounter(), new SprintCounter());

    }

    @Test
    public void canBeClosed() throws Exception {
        ClosedProject closedProject = p.close();
        assertThat(closedProject.getProjectCode()).isEqualTo(p.getProjectCode());
    }

    @Test
    public void projectHasBacklog() throws Exception {
        Backlog pBacklog = p.getBacklog();
        assertThat(pBacklog).isNotNull();
    }

    @Test
    public void canOpenSprint() throws Exception {
        p.createSprint();
        assertThat(p.getBacklog().contains(SprintId.of(p.getProjectCode(), 1)));
    }

    @Test
    public void canOpenIssue() throws Exception {
        p.openIssue();
        assertThat(p.getBacklog().contains(IssueId.of(p.getProjectCode(), 1)));
    }
}
