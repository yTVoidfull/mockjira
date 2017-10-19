package domain.model;

import java.util.HashMap;
import java.util.Map;

public class IssueCounter {
    private Map<ProjectCode, Integer> issueCountByProjectCode = new HashMap<>();

    public int getANewId(ProjectCode projectCode){
        Integer incrementedCount = getIncrementedIssueCountFor(projectCode);
        issueCountByProjectCode.put(projectCode,incrementedCount);
        return incrementedCount;
    }

    public Integer getIncrementedIssueCountFor(ProjectCode projectCode){
        Integer count = issueCountByProjectCode.get(projectCode);
        if(count == null){
            count = 1;
        }
        else {
            count ++;
        }
        return count;
    }

}
