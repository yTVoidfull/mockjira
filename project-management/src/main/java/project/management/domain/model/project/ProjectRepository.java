package project.management.domain.model.project;

import java.util.Optional;

public interface ProjectRepository {

    void add(OpenProject p);

    Optional<OpenProject> get(ProjectCode code);

}
