package domain.model.backlog;

import domain.model.project.ProjectCode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IssueCounterTest {

    @Test
    public void counterIsIncremented() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        IssueCounter iCounter = new IssueCounter();
        assertThat(iCounter.getANewId()).isEqualTo(1);
        assertThat(iCounter.getANewId()).isEqualTo(2);
    }

    @Test
    public void countersAreIndependentOfOneAnother() throws Exception {
        ProjectCode projectCode = new ProjectCode("abcdef123");
        IssueCounter i1 = new IssueCounter();
        IssueCounter i2 = new IssueCounter();

        assertThat(i1.getANewId()).isEqualTo(1);
        assertThat(i1.getANewId()).isEqualTo(2);

        assertThat(i2.getANewId()).isEqualTo(1);
        assertThat(i2.getANewId()).isEqualTo(2);
    }
}
