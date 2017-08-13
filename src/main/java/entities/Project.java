package entities;

import enums.Status;
import exceptions.InvalidProjectIdentifierException;

public class Project {

    private String id;
    private String name;
    private Status status;
    private int duration;

    public Project(String id, String name) throws Exception {
        setId(id);
        setName(name);
        status = Status.CLOSED;
    }

    public Project(String id) throws Exception {
        setId(id);
        status = Status.CLOSED;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) throws Exception {
        validateId(id);
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void validateId(String id) throws Exception{
        if(!id.matches("[A-Za-z]{6}\\d{3}")){
            throw new InvalidProjectIdentifierException();
        }
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
