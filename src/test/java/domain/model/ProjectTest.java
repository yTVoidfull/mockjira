package domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by alplesca on 9/4/2017.
 */
public class ProjectTest {


    @Test
    public void canOpenAProject() throws Exception {
        Project p = new Project("codeAB123");
        assertThat(p.getCode()).isEqualTo("codeAB123");
        assertThat(p.isOpen()).isEqualTo(true);
    }

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
