package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alplesca on 9/28/2017.
 */
public class IssueIdTest {

    @Test
    public void issueIdIsProjectCodeDashIssueId() throws Exception {
        String projectCode = "codeAB123";
        Project p = new Project(projectCode);
        Issue i = p.openIssue();
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
    }

    @Test
    public void issueIdIsIncrementedInAProject() throws Exception {
        String projectCode = "codeAB123";
        Project p = new Project(projectCode);
        Issue i = p.openIssue();
        Issue i1 = p.openIssue();
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
        assertThat(i1.getIssueId().getId()).isEqualTo(projectCode+"-2");
    }

    @Test
    public void issueIdIsIncrementedInDifferentProjects() throws Exception {
        String projectCode = "codeAB123";
        Project p = new Project(projectCode);
        Issue i = p.openIssue();
        Issue i1 = p.openIssue();
        assertThat(i.getIssueId().getId()).isEqualTo(projectCode+"-1");
        assertThat(i1.getIssueId().getId()).isEqualTo(projectCode+"-2");

        String otherProjectCode = "codeAB321";
        Project p1 = new Project(otherProjectCode);
        Issue i3 = p1.openIssue();
        Issue i4 = p1.openIssue();
        assertThat(i3.getIssueId().getId()).isEqualTo(otherProjectCode+"-1");
        assertThat(i4.getIssueId().getId()).isEqualTo(otherProjectCode+"-2");
    }

}
