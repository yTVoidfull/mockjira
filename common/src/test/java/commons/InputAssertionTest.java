package commons;

import org.junit.Test;

import static commons.InputAssertion.assertNotNull;
import static commons.InputAssertion.assertStringMatchesPattern;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class InputAssertionTest {

  @Test
  public void canAssertThatObjectIsNotNull() throws Exception {
    Throwable throwable = catchThrowable(() -> assertNotNull(null, "Message"));
    assertThat(throwable).hasMessage("Message");
  }

  @Test
  public void noExceptionThrownIfObjectIsInstantiated() throws Exception {
    assertNotNull(3, "Message");
  }

  @Test
  public void canAssertThatStringMatchespattern() throws Exception {
    Throwable throwable = catchThrowable(() -> InputAssertion.assertStringMatchesPattern("string", "pattern", "No Match"));
    assertThat(throwable).hasMessage("No Match");
  }

  @Test
  public void noExceptionWhenStringIsMatching() throws Exception {
    assertStringMatchesPattern("aaa","a{3}", "No Match");
  }
}
