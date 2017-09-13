package domain.model;

/**
 * Created by alplesca on 9/4/2017.
 */
public class Project extends Effort{

    private ProjectCode code;

    private IssueCounter issueCounter = new IssueCounter();

    public Project(String code) {
        this.code = new ProjectCode(code);
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
