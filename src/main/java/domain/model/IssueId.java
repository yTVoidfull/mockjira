package domain.model;

public class IssueId {
    private static final String FOMAT = "%s-%d";
    private final String id;

    private IssueId(String id) {
        this.id = id;
    }

    public static IssueId of(ProjectCode projectCode, int id) {
        return new IssueId(String.format(FOMAT, projectCode, id));
    }

    public String getId() {
        return id;
    }
}
