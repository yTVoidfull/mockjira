package entities;

import enums.Status;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class IssueTest {

    @Test
    public void anIssueIsOpenedOnlyInAProject() throws Exception {
        Project project = new Project("abcdef123");
        Issue issue = new Issue(project);
    }

    @Test
    public void issueIdIsProjectNamePlusAutomaticIncrementor() throws Exception {
        Project project = new Project("abcdef123");
        Issue issue = new Issue(project);
        Issue otherIssue = new Issue(project);
        Assert.assertThat(issue.getId(), is(project.getName() + " 1"));
        Assert.assertThat(otherIssue.getId(), is(project.getName() + " 2"));
    }

    @Test
    public void issuesHaveStatusClosedByDefault() throws Exception {
        Project project = new Project("abcdef123");
        Issue issue = new Issue(project);
        Assert.assertThat(issue.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void issuesCanBeOpened() throws Exception {
        Project project = new Project("abcdef123");
        Issue issue = new Issue(project);
        issue.open();
        Assert.assertThat(issue.getStatus(), is(Status.OPEN));
    }

    @Test
    public void issuesCanBeClosed() throws Exception {
        Project project = new Project("abcdef123");
        Issue issue = new Issue(project);
        issue.open();
        Assert.assertThat(issue.getStatus(), is(Status.OPEN));
        issue.closed();
        Assert.assertThat(issue.getStatus(), is(Status.CLOSED));
    }
}
