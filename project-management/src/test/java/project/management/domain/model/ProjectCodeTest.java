package project.management.domain.model;

import project.management.domain.model.Project;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.backlog.BacklogItemRepository;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.issue.IssueRepository;
import project.management.domain.model.sprint.SprintCounter;
import project.management.domain.model.sprint.SprintRepository;
import project.management.infrastructure.persistence.InMemoryIssueRepository;
import project.management.infrastructure.persistence.InMemorySprintRepository;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ProjectCodeTest {

    Backlog backlog;

    @Before
    public void setUp(){
        backlog = new Backlog(null, null);
    }

    @Test
    public void exceptionThrownWhenCodeIsNull() throws Exception {
        Throwable codeNullException = catchThrowable(() -> new ProjectCode(null));
        assertThat(codeNullException).hasMessage("Code must not be null");
    }

    @Test
    public void exceptionThrownWhenCodeIsLongerThanNineCharacters() throws Exception {
        String tenCharacterId = "codeAB1234";
        Throwable codeNullException = catchThrowable(() -> new Project(new ProjectCode(tenCharacterId), backlog, new IssueCounter(), new SprintCounter()));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeIsShorterThanNineCharacters() throws Exception {
        String eightCharacterId = "code1234";
        Throwable codeNullException = catchThrowable(() -> new ProjectCode(eightCharacterId));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeHasLeadingFiveLettersAndFourDigits() throws Exception {
        String leadingFiveLetters = "codea1234";
        Throwable codeNullException = catchThrowable(() -> new ProjectCode(leadingFiveLetters));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeHasLeadingSevenLettersAndTwoDigits() throws Exception {
        String leadingSevenLetters = "codeabs12";
        Throwable codeNullException = catchThrowable(() -> new ProjectCode(leadingSevenLetters));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void twoProjectCodesWithSameStringBaseAreEqual() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        ProjectCode projectCode1 = new ProjectCode("abcdef123");
        assertThat(projectCode).isEqualTo(projectCode1);
    }
    
}
