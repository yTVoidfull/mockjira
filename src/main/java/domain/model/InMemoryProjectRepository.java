package domain.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryProjectRepository implements ProjectRepository {

  private Set<Project> projects = new HashSet<>();

  public InMemoryProjectRepository() {
  }

  @Override
  public void add(Project project) {
    if (projects.contains(project)) {
      throw new IllegalStateException("Project with this code already exists");
    }
    projects.add(project);

  }

  @Override
  public Optional<Project> get(ProjectCode code) {
    for (Project p : projects) {
      if (p.getCode().equals(code)) {
        return Optional.of(p);
      }
    }
    return Optional.empty();
  }

  public boolean contains(Project project) {
    return projects.contains(project);
  }

}
