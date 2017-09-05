package domain.model;

/**
 * Created by alplesca on 9/4/2017.
 */
public class Project {

    private String code;

    public Project(String code) {
        if(code == null ||
                !code.matches("[A-Za-z]{6}\\d{3}")){
            throw new IllegalArgumentException("Code must be 6 letters and 3 digits");
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
