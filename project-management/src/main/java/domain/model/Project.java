package domain.model;

import java.util.Objects;

public class Project {
    private ProjectCode code;
    private boolean isOpen = true;

    public Project(ProjectCode code) {
        this.code = code;
    }

    public ProjectCode getCode() {
        return code;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return isOpen == project.isOpen &&
            Objects.equals(code, project.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, isOpen);
    }

}
