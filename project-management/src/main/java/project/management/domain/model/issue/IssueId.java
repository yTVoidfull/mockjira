package project.management.domain.model.issue;


import project.management.domain.model.project.ProjectCode;

import java.util.Objects;

import static commons.InputAssertion.assertNotNull;

public class IssueId {
    private static final String FOMAT = "%s-%d";
    private final String id;

    private IssueId(String id) {
        this.id = id;
    }

    public static IssueId of(ProjectCode projectCode, int id) {
        assertNotNull(projectCode, "OpenProject code must not be null");
        return new IssueId(String.format(FOMAT, projectCode, id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueId)) return false;
        IssueId issueId = (IssueId) o;
        return Objects.equals(id, issueId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }
}
