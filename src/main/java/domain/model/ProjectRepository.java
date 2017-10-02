package domain.model;

import java.util.Optional;

public interface ProjectRepository {

    void add(Project p);

    Optional<Project> get(ProjectCode code);

}
