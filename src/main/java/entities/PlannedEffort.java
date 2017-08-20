package entities;

import enums.Status;

public abstract class PlannedEffort {

    private Status status;

    public PlannedEffort(){
        status = Status.CLOSED;
    }

    public void start() {
        status = Status.OPEN;
    }

    public void end() {
        status = Status.CLOSED;
    }

    public Status getStatus() {
        return status;
    }

}
