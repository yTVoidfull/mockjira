package project.management.application;


import project.management.domain.model.project.OpenProject;
import project.management.domain.model.project.ProjectCode;
import project.management.domain.model.project.ProjectRepository;
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
            .map(OpenProject::openIssue)
            .orElseThrow(() -> new IllegalStateException("Issues must be created for existing projects"));
        issueRepository.add(issue);
        return issue;
    }
}
