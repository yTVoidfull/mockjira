package project.management.domain.model.issue;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;

import static org.assertj.core.api.Assertions.assertThat;


public class IssueIdTest {

    ProjectCode projectCode;

    @Before
    public void setUp(){
        projectCode = new ProjectCode("abcdef123");
    }

    @Test
    public void issueIdIsProjectCodeDashIssueId() throws Exception {
        Issue i = Issue.of(IssueId.of(projectCode,1));
        assertThat(i.getId().getId()).isEqualTo(projectCode+"-1");
    }

    @Test
    public void issuesWithSameProjectCodeAndIdAreEqual() throws Exception {
        IssueId id1 = IssueId.of(projectCode, 1);
        IssueId id2 = IssueId.of(projectCode, 1);
        assertThat(id1).isEqualTo(id2);
        assertThat(id1.hashCode()).isEqualTo(id2.hashCode());
    }
}
