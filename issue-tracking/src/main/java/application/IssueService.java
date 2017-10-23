package application;

import domain.model.backlog.*;

public class IssueService {

    private ProjectRepository projectRepository;
    private IssueRepository issueRepository;

    public IssueService(ProjectRepository projectRepository, IssueRepository issueRepository) {
        this.projectRepository = projectRepository;
        this.issueRepository = issueRepository;
    }

    public Issue openFor(ProjectCode projectCode) {
        Issue issue = projectRepository.get(projectCode)
            .map(OpenProject::open)
            .orElseThrow(() -> new IllegalStateException("Issues must be created for existing projects"));
        issueRepository.add(issue);
        return issue;
    }
}
