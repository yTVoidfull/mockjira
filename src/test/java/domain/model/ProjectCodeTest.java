package domain.model;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ProjectCodeTest {

    @Test
    public void exceptionThrownWhenCodeIsNull() throws Exception {
        Throwable codeNullException = catchThrowable(() -> new ProjectCode(null));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeIsLongerThanNineCharacters() throws Exception {
        String tenCharacterId = "codeAB1234";
        Throwable codeNullException = catchThrowable(() -> new Project(new ProjectCode(tenCharacterId)));
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

    @Test
    public void aProjectCodeIsEqualToAString() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        String projectCodeString = "abcdef123";
        assertThat(projectCode).isEqualTo(projectCodeString);
    }
}
