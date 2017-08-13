package entities;

import enums.Status;

public class Sprint {


    private Project project;
    private Status status;

    public Sprint(Project project) {
        this.project = project;
        status = Status.CLOSED;
    }

    public Status getStatus() {
        return status;
    }

    public void open() {
        status = Status.OPEN;
    }

    public void close() {
        status = Status.CLOSED;
    }
}
