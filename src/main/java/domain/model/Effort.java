package domain.model;

/**
 * Created by alplesca on 9/28/2017.
 */
public abstract class Effort {

    private boolean isOpen = true;

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

}
