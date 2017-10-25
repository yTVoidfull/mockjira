package domain.model;

import domain.model.backlog.Backlog;
import domain.model.issue.IssueCounter;
import domain.model.sprint.Sprint;
import domain.model.sprint.SprintCounter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ProjectTest {

    Project p;

    @Before
    public void setUp(){
        p = new Project(new ProjectCode("codeAB123"), new Backlog(), new IssueCounter(), new SprintCounter());

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
        assertThat(pBacklog.get("codeAB123-1")).isNotEmpty();
    }

}
