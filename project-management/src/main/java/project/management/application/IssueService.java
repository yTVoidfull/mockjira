package project.management.application;


import project.management.domain.model.Project;
import project.management.domain.model.ProjectCode;
import project.management.domain.model.ProjectRepository;
import project.management.domain.model.issue.Issue;
import project.management.domain.model.issue.IssueRepository;

public class IssueService {

    private ProjectRepository projectRepository;
    private IssueRepository issueRepository;

    public IssueService(ProjectRepository projectRepository, IssueRepository issueRepository) {
        this.projectRepository = projectRepository;
        this.issueRepository = issueRepository;
    }

    public Issue openFor(ProjectCode projectCode) {
        Issue issue = projectRepository.get(projectCode)
            .map(Project::openIssue)
            .orElseThrow(() -> new IllegalStateException("Issues must be created for existing projects"));
        issueRepository.add(issue);
        return issue;
    }
}
