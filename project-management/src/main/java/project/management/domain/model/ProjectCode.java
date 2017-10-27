package project.management.domain.model;

import java.util.Objects;

import static commons.InputAssertion.assertNotNull;
import static commons.InputAssertion.assertStringMatchesPattern;

public class ProjectCode {
    private String code;

    public ProjectCode(String code) {
        assertNotNull(code, "Code must not be null");
        assertStringMatchesPattern(code, "[A-Za-z]{6}\\d{3}", "Code must be 6 letters and 3 digits");
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
