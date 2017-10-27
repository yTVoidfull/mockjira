package project.management.domain.model.issue;

import org.junit.Before;
import org.junit.Test;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.issue.Issue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class IssueTest {

  ProjectCode projectCode;

  @Before
  public void setUp(){
    projectCode = new ProjectCode("abcdef123");
  }

  @Test
  public void issueCreatedIsOpen() throws Exception {
    Issue i = Issue.of(IssueId.of(projectCode, 1));
    assertThat(i.isOpen()).isEqualTo(true);
  }

  @Test
  public void canBeClosed() throws Exception {
    Issue i = Issue.of(IssueId.of(projectCode, 1));
    i.close();
    assertThat(i.isOpen()).isEqualTo(false);
  }

}
