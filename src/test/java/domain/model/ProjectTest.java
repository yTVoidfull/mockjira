package domain.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by alplesca on 9/4/2017.
 */
public class ProjectTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void canOpenAProject() throws Exception {
        Project p = new Project("codeAB123");
        Assert.assertThat(p.getCode(), is("codeAB123")); // TODO use assertJ
        Assert.assertThat(p.isOpen(), is(true));
    }

    @Test
    public void exceptionThrownWhenCodeIsNull() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Code must be 9 characters");
        new Project(null);
    }

    @Test
    public void exceptionThrownWhenCodeIsLongerThanNineCharacters() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Code must be 9 characters");
        new Project("codeAB1234");
    }

    @Test
    public void exceptionThrownWhenCodeIsShorterThanNineCharacters() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Code must be 9 characters");
        new Project("code1234");
    }
}
