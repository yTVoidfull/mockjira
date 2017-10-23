package domain.model.backlog;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ProjectRepository {

  private Set<OpenProject> projects = new HashSet<>();

  public ProjectRepository() {
  }

  public void add(OpenProject project) {
    if(project == null){
      throw new IllegalStateException("Project cannot be null");
    }
    else if (projects.contains(project)) {
      throw new IllegalStateException("Project with this code already exists");
    }
    projects.add(project);

  }

  public Optional<OpenProject> get(ProjectCode code) {
    for (OpenProject p : projects) {
      if (p.getCode().equals(code)) {
        return Optional.of(p);
      }
    }
    return Optional.empty();
  }

  public boolean contains(OpenProject project) {
    return projects.contains(project);
  }

}
