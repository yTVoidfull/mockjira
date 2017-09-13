package domain.model;

/**
 * Created by alplesca on 9/11/2017.
 */
public class Issue extends Effort {

    private final IssueId issueId;


    private Issue(IssueId issueId) {
        this.issueId = issueId;
    }

    public static Issue open(ProjectCode projectCode, int id) {
        return new Issue(IssueId.of(projectCode, id));
    }

    public IssueId getIssueId() {
        return issueId;
    }

}