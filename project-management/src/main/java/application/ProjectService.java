package application;

import domain.model.backlog.Backlog;
import domain.model.issue.IssueCounter;
import domain.model.Project;
import domain.model.ProjectCode;
import domain.model.ProjectRepository;
import domain.model.sprint.SprintCounter;

import java.util.Optional;

public class ProjectService {

  private ProjectRepository repo;

  public ProjectService(ProjectRepository repo) {
    this.repo = repo;
  }

  public Project create(ProjectCode projectCode) {
    Project p = new Project(projectCode, new Backlog(), new IssueCounter(), new SprintCounter());
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
