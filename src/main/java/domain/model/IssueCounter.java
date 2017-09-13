package domain.model;

/**
 * Created by alplesca on 9/13/2017.
 */
public class IssueCounter {

    private int counter = 1;

    public int getANewId(){
        return counter ++;
    }

}
