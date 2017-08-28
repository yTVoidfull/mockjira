package entities;

import exceptions.InvalidProjectIdentifierException;

public class Project extends PlannedEffort{

    private String id;
    private String name;
    private int duration;

    private Project(String id, String name) throws Exception {
        super();
        setId(id);
        setName(name);
    }

    private Project(String id) throws Exception {
        super();
        setId(id);
    }

    public static Project createProjectWithId(String id) throws Exception {
        return new Project(id);
    }

    public static Project createProjectWithIdAndName(String id, String name) throws Exception {
        return new Project(id, name);
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

}
