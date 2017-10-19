package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IssueIdTest {

    @Test
    public void issueIdIsProjectCodeDashIssueId() throws Exception {
        ProjectCode projectCode = new ProjectCode("codeAB123");
        Issue i = Issue.open(projectCode,1);
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
    }

}
