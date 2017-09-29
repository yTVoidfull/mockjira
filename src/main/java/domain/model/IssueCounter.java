package domain.model;

public class IssueCounter {
    private int counter = 1;

    public int getANewId(){
        return counter ++;
    }

}
