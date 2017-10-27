package project.management.domain.model.user;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UserTest {

    @Test
    public void aUserHasUserName() throws Exception {
        Username username = new Username("example.blah@test.com");
        User user = new User(username);
        assertThat(user.getUsername()).isEqualTo(username);
    }


}
