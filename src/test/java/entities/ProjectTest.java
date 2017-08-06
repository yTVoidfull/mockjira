package entities;

import exceptions.InvalidProjectIdentifierException;
import org.junit.Assert;
import org.junit.Test;

public class ProjectTest {

    @Test
    public void eachProjectHasAnIdentifier() throws Exception {
        new Project("abcdef123", "Unique Project");
    }

    @Test
    public void projectNameIsNotMandatory() throws Exception {
        new Project("abcdef123");
    }

    @Test
    public void projectNameIsExactlyNineCHaractersInLength() throws Exception {
        try{
            new Project("abcd12");
            Assert.fail();
        }catch (InvalidProjectIdentifierException invalid){
        }
    }
}
