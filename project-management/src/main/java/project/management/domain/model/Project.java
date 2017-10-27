package project.management.domain.model;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.sprint.SprintCounter;

import java.util.Objects;

import static commons.InputAssertion.assertNotNull;

public class Project {
    private final String ISSUE_ID_FORMAT = "%s-%s";

    private final IssueCounter issueCounter;
    private final SprintCounter sprintCounter;
    private final ProjectCode code;
    private boolean isOpen;
    private final Backlog backlog;

    public Project(ProjectCode code, Backlog backlog, IssueCounter issueCounter, SprintCounter sprintCounter) {
        assertNotNull(code, "Code must not be null");
        assertNotNull(backlog, "Backlog must not be null");
        assertNotNull(issueCounter, "Issue counter must not be null");
        assertNotNull(sprintCounter, "Sprint counter must not be null");
        this.code = code;
        this.backlog = backlog;
        this.issueCounter = issueCounter;
        this.sprintCounter = sprintCounter;
        this.isOpen = true;
    }

    public ProjectCode getCode() {
        return code;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return isOpen == project.isOpen &&
            Objects.equals(code, project.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, isOpen);
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public Issue openIssue() {
        Issue i = Issue.of(IssueId.of(code, issueCounter.getANewId()));
        return i;
    }
}
