package entities;

public class Issue extends Effort {

    private final String NAME_PREFIX = "Issue ";

    private static int lastIssueId = 1;
    private int id;
    private String name;


    Issue(Project project) {
        super(project);
        id = lastIssueId;
        name = NAME_PREFIX + lastIssueId;
        lastIssueId ++;
    }

    public static int getLastIssueId() {
        return lastIssueId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
