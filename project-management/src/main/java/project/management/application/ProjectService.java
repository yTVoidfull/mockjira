package project.management.application;

import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.Project;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.ProjectRepository;
import project.management.domain.model.sprint.SprintCounter;

import java.util.Optional;

public class ProjectService {

  private ProjectRepository repo;

  public ProjectService(ProjectRepository repo) {
    this.repo = repo;
  }

  public Project create(ProjectCode projectCode, Backlog backlog) {
    Project p = new Project(projectCode, backlog, new IssueCounter(), new SprintCounter());
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
