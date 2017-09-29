package domain.model;


public abstract class Effort {
    private boolean isOpen = true;

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

}
