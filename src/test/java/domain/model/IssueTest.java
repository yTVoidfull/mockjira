package domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IssueTest {

    @Test
    public void canBeOpen() throws Exception {
        Issue i = Issue.open(new ProjectCode("codeAB123"), 1);
        assertThat(i.isOpen()).isEqualTo(true);
    }

    @Test
    public void canBeClosed() throws Exception {
        Issue i = Issue.open(new ProjectCode("codeAB123"), 1);
        i.close();
        assertThat(i.isOpen()).isEqualTo(false);
    }
}
