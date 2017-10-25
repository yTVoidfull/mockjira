package domain.model.backlog;

import domain.model.project.ProjectCode;

public class Issue {
    private final IssueId issueId;
    private boolean isOpen = true;

    private Issue(IssueId issueId) {
        this.issueId = issueId;
    }

    public static Issue openFor(ProjectCode projectCode, int id) {
            return new Issue(IssueId.of(projectCode, id));
        }

    public IssueId getIssueId() {
        return issueId;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

}