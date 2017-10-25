package domain.model.backlog;

import domain.model.project.ProjectCode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueTest {

    @Test
    public void canBeOpen() throws Exception {
        Issue i = Issue.openFor(new ProjectCode("codeAB123"), 1);
        assertThat(i.isOpen()).isEqualTo(true);
    }

    @Test
    public void canBeClosed() throws Exception {
        Issue i = Issue.openFor(new ProjectCode("codeAB123"), 1);
        i.close();
        assertThat(i.isOpen()).isEqualTo(false);
    }
}
