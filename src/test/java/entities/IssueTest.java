package entities;

import enums.Status;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class IssueTest {

    @Test
    public void anIssueIsOpenedOnlyInAProject() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue =  project.createIssue();
    }

    @Test
    public void issueIdIsAnIncrementor() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue = project.createIssue();
        Issue otherIssue = project.createIssue();
        Assert.assertThat(issue.getId(), is(Issue.getLastIssueId()-2));
        Assert.assertThat(otherIssue.getId(), is( Issue.getLastIssueId()-1));
    }

    @Test
    public void issueNameIsClassNamePlusAnIncrementor() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue = project.createIssue();
        Issue otherIssue = project.createIssue();
        Assert.assertThat(issue.getName(), is("Issue "+(Issue.getLastIssueId()-2)));
        Assert.assertThat(otherIssue.getName(), is( "Issue "+(Issue.getLastIssueId()-1)));
    }

    @Test
    public void issuesHaveStatusClosedByDefault() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue = project.createIssue();
        Assert.assertThat(issue.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void issuesCanBeOpened() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue = project.createIssue();
        issue.start();
        Assert.assertThat(issue.getStatus(), is(Status.OPEN));
    }

    @Test
    public void issuesCanBeClosed() throws Exception {
        Project project = Project.createProjectWithId("abcdef123");
        Issue issue = project.createIssue();
        issue.start();
        Assert.assertThat(issue.getStatus(), is(Status.OPEN));
        issue.end();
        Assert.assertThat(issue.getStatus(), is(Status.CLOSED));
    }
}
