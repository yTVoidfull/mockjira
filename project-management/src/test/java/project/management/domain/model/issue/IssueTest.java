package project.management.domain.model.issue;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.project.ProjectCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IssueTest {

  ProjectCode projectCode;

  @Before
  public void setUp(){
    projectCode = new ProjectCode("abcdef123");
  }

  @Test
  public void issueCreatedIsOpen() throws Exception {
    Issue i = Issue.of(IssueId.of(projectCode, 1));
    assertThat(i.getStatus()).isEqualTo(IssueStatus.OPEN);
  }

}
