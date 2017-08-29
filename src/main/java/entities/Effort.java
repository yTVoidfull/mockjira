package entities;

import enums.Status;

public abstract class Effort {

    private Status status;
    private Project project;

    public Effort(Project project){
        this.project = project;
        this.status = Status.CLOSED;
    }

    public Effort() {
        this.status = Status.CLOSED;
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
