package domain.model;

public class Project extends Effort{
    private ProjectCode code;
    private IssueCounter issueCounter = new IssueCounter();

    public Project(ProjectCode code) {
        this.code = code;
    }

    public ProjectCode getCode() {
        return code;
    }

    public Issue openIssue() {
        if(!isOpen()) {
            throw new IllegalStateException("Issues must be created only in ongoing projects");
        }
        return Issue.open(code, issueCounter.getANewId());
    }

}
