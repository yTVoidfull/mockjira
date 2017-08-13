package entities;

import enums.Status;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SprintTest {

    @Test
    public void aSprintIsCreatedForAProject() throws Exception {
        Project project = new Project("abcdef123");
        Sprint sprint = new Sprint(project);
    }

    @Test
    public void aSprintIsClosedByDefault() throws Exception {
        Project project = new Project("abcdef123");
        Sprint sprint = new Sprint(project);
        Assert.assertThat(sprint.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void aSprintCanBeOpened() throws Exception {
        Project project = new Project("abcdef123");
        Sprint sprint = new Sprint(project);
        sprint.open();
        Assert.assertThat(sprint.getStatus(), is(Status.OPEN));
    }

    @Test
    public void aSprintCanBeClosed() throws Exception {
        Project project = new Project("abcdef123");
        Sprint sprint = new Sprint(project);
        sprint.open();
        Assert.assertThat(sprint.getStatus(), is(Status.OPEN));
        sprint.close();
        Assert.assertThat(sprint.getStatus(), is(Status.CLOSED));
    }
}
