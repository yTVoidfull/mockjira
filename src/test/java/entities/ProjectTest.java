package entities;

import enums.Status;
import exceptions.InvalidProjectIdentifierException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ProjectTest {

    @Test
    public void eachProjectHasAnIdentifier() throws Exception {
        Project project = new Project("abcdef123", "Unique Project");
        Assert.assertThat(project.getId(), is("abcdef123"));
    }

    @Test
    public void projectNameIsNotMandatory() throws Exception {
        new Project("abcdef123");
    }

    @Test
    public void projectIdIsExactlyNineCHaractersInLength() throws Exception {
        try{
            new Project("abcd12");
            Assert.fail();
        }catch (InvalidProjectIdentifierException invalid){
        }
    }

    @Test
    public void projectIdIsComposedOfSixLettersAndThreeDigits() throws Exception {
        new Project("abcdef123");
        try {
            new Project("abcdef12a");
            Assert.fail();
        }catch (InvalidProjectIdentifierException invalid){
        }
    }

    @Test
    public void aProjectHasStatusClosedByDefault() throws Exception {
        Project project = new Project("abcdef123");
        Assert.assertThat(project.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void aProjectCanBeStarted() throws Exception {
        Project project = new Project("abcdef123");
        project.start();
        Assert.assertThat(project.getStatus(), is(Status.OPEN));
    }

    @Test
    public void aProjectCanBeClosed() throws Exception {
        Project project = new Project("abcdef123");
        project.start();
        Assert.assertThat(project.getStatus(), is(Status.OPEN));
        project.end();
        Assert.assertThat(project.getStatus(), is(Status.CLOSED));
    }

    @Test
    public void aProjectHasDuration() throws Exception {
        Project project = new Project("abcdef123");
        project.setDuration(100);
        Assert.assertThat(project.getDuration(), is(100));
    }
}
