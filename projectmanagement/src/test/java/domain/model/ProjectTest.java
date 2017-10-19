package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ProjectTest {

    @Test
    public void canOpen() throws Exception {
        Project p = new Project(new ProjectCode("codeAB123"));
        assertThat(p.getCode().toString()).isEqualTo("codeAB123");
        assertThat(p.isOpen()).isEqualTo(true);
    }

    @Test
    public void canBeClosed() throws Exception {
        Project p = new Project(new ProjectCode("codeAB123"));
        p.close();
        assertThat(p.isOpen()).isEqualTo(false);
    }

}
