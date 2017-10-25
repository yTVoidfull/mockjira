package domain.model.backlog;

import domain.model.project.ProjectCode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IssueIdTest {

    @Test
    public void issueIdIsProjectCodeDashIssueId() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        Issue i = Issue.openFor(projectCode,1);
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
    }

    @Test
    public void issuesWithSameProjectCodeAndIdAreEqual() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        IssueId id1 = IssueId.of(projectCode, 1);
        IssueId id2 = IssueId.of(projectCode, 1);
        assertThat(id1).isEqualTo(id2);
        assertThat(id1.hashCode()).isEqualTo(id2.hashCode());
    }
}
