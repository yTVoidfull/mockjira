package project.management.infrastructure.persistence;

import project.management.domain.model.project.OpenProject;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.project.ProjectRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryProjectRepository implements ProjectRepository {

  private Set<OpenProject> openProjects = new HashSet<>();

  public InMemoryProjectRepository() {
  }

  @Override
  public void add(OpenProject openProject) {
    if(openProject == null){
      throw new IllegalStateException("OpenProject cannot be null");
    }
    else if (openProjects.contains(openProject)) {
      throw new IllegalStateException("OpenProject with this code already exists");
    }
    openProjects.add(openProject);

  }

  @Override
  public Optional<OpenProject> get(ProjectCode code) {
    for (OpenProject p : openProjects) {
      if (p.getProjectCode().equals(code)) {
        return Optional.of(p);
      }
    }
    return Optional.empty();
  }

  public boolean contains(OpenProject openProject) {
    return openProjects.contains(openProject);
  }

}
