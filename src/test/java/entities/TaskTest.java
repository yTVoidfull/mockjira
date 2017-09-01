package entities;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by alplesca on 9/1/2017.
 */
public class TaskTest {

    @Test
    public void eachTaskHasAnIdWithNameAndIncrementor() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Task task = project.createTask(project);
        Task secondTask = project.createTask(project);
        Assert.assertThat(task.getId(), is(1));
        Assert.assertThat(task.getName(), is("Task 1"));
        Assert.assertThat(secondTask.getId(), is(2));
        Assert.assertThat(secondTask.getName(), is("Task 2"));
    }

    @Test
    public void everyCreatedTaskIsAddedToListOfTasks() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Task task = project.createTask(project);
        Assert.assertThat(project.getTasks().get(0), is(task));
    }
}
