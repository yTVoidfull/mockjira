package application;

import domain.model.InMemoryProjectRepository;
import domain.model.Project;
import domain.model.ProjectCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectService {

  private InMemoryProjectRepository repo = new InMemoryProjectRepository();

  public Project create(ProjectCode projectCode) {
    Project p = new Project(projectCode);
    repo.add(p);
    return p;
  }

  public Optional get(ProjectCode projectCode) {
    return repo.get(projectCode);
  }

  public void close(ProjectCode projectCode) {
    Optional op = repo.get(projectCode);
    if (!op.isPresent()) {
      throw new IllegalStateException("There is no project with given code");
    }
    Project p = (Project) op.get();
    p.close();
  }
}
