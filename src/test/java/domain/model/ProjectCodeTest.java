package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * Created by alplesca on 9/28/2017.
 */
public class ProjectCodeTest {

    @Test
    public void exceptionThrownWhenCodeIsNull() throws Exception {
        Throwable codeNullException = catchThrowable(() -> new Project(null));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeIsLongerThanNineCharacters() throws Exception {
        String tenCharacterId = "codeAB1234";
        Throwable codeNullException = catchThrowable(() -> new Project(tenCharacterId));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeIsShorterThanNineCharacters() throws Exception {
        String eightCharacterId = "code1234";
        Throwable codeNullException = catchThrowable(() -> new Project(eightCharacterId));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeHasLeadingFiveLettersAndFourDigits() throws Exception {
        String leadingFiveLetters = "codea1234";
        Throwable codeNullException = catchThrowable(() -> new Project(leadingFiveLetters));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }

    @Test
    public void exceptionThrownWhenCodeHasLeadingSevenLettersAndTwoDigits() throws Exception {
        String leadingSevenLetters = "codeabs12";
        Throwable codeNullException = catchThrowable(() -> new Project(leadingSevenLetters));
        assertThat(codeNullException).hasMessage("Code must be 6 letters and 3 digits");
    }
}
