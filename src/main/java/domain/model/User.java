package domain.model;

public class User {

    private Username username;

    public User(Username username) {
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }
}
