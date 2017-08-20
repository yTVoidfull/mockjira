package entities;

import com.sun.xml.internal.ws.api.message.Packet;
import enums.Status;

public class Issue {

    private Project project;
    private static int lastIssueId = 1;
    private String id;
    private Status status;

    public Issue(Project project) {
        this.project = project;
        id = project.getName() + " " + lastIssueId;
        lastIssueId ++;
        status = Status.CLOSED;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void open() {
        status = Status.OPEN;
    }

    public void closed() {
        status = Status.CLOSED;
    }

}
