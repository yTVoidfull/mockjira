package application;

import domain.model.*;

import java.util.Optional;

public class IssueService {
    private ProjectRepository repo;
    private IssueCounter issueCounter;

    public IssueService(IssueCounter issueCounter, ProjectRepository repo) {
        this.repo = repo;
        this.issueCounter = issueCounter;
    }

    public Issue openFor(ProjectCode projectCode) {
        Optional<Project> optional = repo.get(projectCode);
        if(optional.isPresent()){
            Project p = optional.get();
            if(p.isOpen()){
                return Issue.open(projectCode, issueCounter.getANewId(projectCode));
            }
            throw new IllegalStateException("Issues must be created only in ongoing projects");
        }
        throw new IllegalStateException("Issues must be created for existing projects");
    }
}
