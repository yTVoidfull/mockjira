package domain.model.backlog;

public class IssueCounter {
    private Integer issueCount = 1;

    public int getANewId(){
        return issueCount ++;
    }

}
