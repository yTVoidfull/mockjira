package domain.model;

/**
 * Created by alplesca on 9/4/2017.
 */
public class Project {

    private String code;

    public Project(String code) {
        if(code == null || code.length() != 9) {
            throw new IllegalArgumentException("Code must be 9 characters");
        }
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean isOpen() {
        return true;
    }
}
