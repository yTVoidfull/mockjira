package domain.model;

import domain.model.Project;
import domain.model.ProjectCode;

import java.util.Optional;

public interface ProjectRepository {

    void add(Project p);

    Optional<Project> get(ProjectCode code);

}
