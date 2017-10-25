package domain.model;

import domain.model.backlog.Backlog;
import domain.model.issue.Issue;
import domain.model.issue.IssueCounter;
import domain.model.sprint.Sprint;
import domain.model.sprint.SprintCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Project {
    private final String ISSUE_ID_FORMAT = "%s-%s";

    private final IssueCounter issueCounter;
    private final SprintCounter sprintCounter;
    private final ProjectCode code;
    private boolean isOpen;
    private final Backlog backlog;

    public Project(ProjectCode code, Backlog backlog, IssueCounter issueCounter, SprintCounter sprintCounter) {
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

    public Issue openIssue() {
        Issue i = Issue.of(String.format(ISSUE_ID_FORMAT, code, issueCounter.getANewId()));
        backlog.add(i);
        return i;
    }

    public Backlog getBacklog() {
        return backlog;
    }
}
