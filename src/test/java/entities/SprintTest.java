package entities;

import enums.Status;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SprintTest {

    @Test
    public void aSprintIsCreatedForAProject() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Sprint sprint = project.createSprint();
    }

    @Test
    public void aSprintIsClosedByDefault() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Sprint sprint = project.createSprint();
        Assert.assertThat(sprint.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void aSprintCanBeOpened() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Sprint sprint = project.createSprint();
        sprint.start();
        Assert.assertThat(sprint.getStatus(), is(Status.OPEN));
    }

    @Test
    public void aSprintCanBeClosed() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Sprint sprint = project.createSprint();
        sprint.start();
        Assert.assertThat(sprint.getStatus(), is(Status.OPEN));
        sprint.end();
        Assert.assertThat(sprint.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void eachSprintHasAListOfTasks() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Sprint sprint = project.createSprint();
        sprint.getTasks();
    }
}
