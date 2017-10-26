package project.management.domain.model.issue;

public class IssueCounter {
    private Integer issueCount = 1;

    public int getANewId(){
        return issueCount ++;
    }

}
