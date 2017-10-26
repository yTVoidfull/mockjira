package project.management.domain.model;

import java.util.Objects;

public class ProjectCode {
    private String code;

    public ProjectCode(String code) {
        if(code == null ||
                !code.matches("[A-Za-z]{6}\\d{3}")){
            throw new IllegalArgumentException("Code must be 6 letters and 3 digits");
        }
        this.code = code;
    }

    @Override
    public String toString(){
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectCode that = (ProjectCode) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
