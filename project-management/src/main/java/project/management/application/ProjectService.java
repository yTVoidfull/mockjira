package project.management.application;

import project.management.domain.model.project.ClosedProject;
import project.management.domain.model.project.OpenProject;
import project.management.domain.model.backlog.Backlog;
import project.management.domain.model.issue.IssueCounter;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.project.ProjectRepository;
import project.management.domain.model.sprint.SprintCounter;

import java.util.Optional;

public class ProjectService {

  private ProjectRepository repo;

  public ProjectService(ProjectRepository repo) {
    this.repo = repo;
  }

  public OpenProject create(ProjectCode projectCode, Backlog backlog) {
    OpenProject p = new OpenProject(projectCode, backlog, new IssueCounter(), new SprintCounter());
    repo.add(p);
    return p;
  }

  public Optional get(ProjectCode projectCode) {
    return repo.get(projectCode);
  }

  public ClosedProject close(ProjectCode projectCode) {
    Optional op = repo.get(projectCode);
    if (!op.isPresent()) {
      throw new IllegalStateException("There is no project with given code");
    }
    OpenProject p = (OpenProject) op.get();
    return p.close();
  }
}
