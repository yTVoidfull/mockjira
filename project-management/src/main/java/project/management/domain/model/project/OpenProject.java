package project.management.domain.model.project;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueId;
import project.management.domain.model.sprint.Sprint;
import project.management.domain.model.sprint.SprintCounter;
import project.management.domain.model.sprint.SprintId;

import java.util.Objects;

public class OpenProject {
    private final IssueCounter issueCounter;
    private final SprintCounter sprintCounter;
    private final ProjectCode projectCode;
    private final Backlog backlog;

    public OpenProject(ProjectCode projectCode, Backlog backlog, IssueCounter issueCounter, SprintCounter sprintCounter) {
        this.projectCode = projectCode;
        this.backlog = backlog;
        this.issueCounter = issueCounter;
        this.sprintCounter = sprintCounter;
    }

    public ProjectCode getProjectCode() {
        return projectCode;
    }

    public ClosedProject close() {
        return new ClosedProject(projectCode);
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof OpenProject)) return false;
    OpenProject that = (OpenProject) o;
    return Objects.equals(projectCode, that.projectCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectCode);
  }

  public Backlog getBacklog() {
        return backlog;
    }

    public Issue openIssue() {
        Issue i = Issue.of(IssueId.of(projectCode, issueCounter.getANewId()));
        backlog.add(i);
        return i;
    }

    public Sprint createSprint() {
        Sprint s = Sprint.of(SprintId.of(projectCode, sprintCounter.getNewId()));
        backlog.add(s);
        return s;
    }
}
