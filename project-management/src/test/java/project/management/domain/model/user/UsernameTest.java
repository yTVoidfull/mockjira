package project.management.domain.model.user;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UsernameTest {

  @Test
  public void usernameHasAStringBase() throws Exception {
    Username username =new Username("username");
    assertThat(username.getUsername()).isEqualTo("username");
  }
}
