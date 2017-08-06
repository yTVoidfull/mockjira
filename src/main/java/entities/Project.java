package entities;

import exceptions.InvalidProjectIdentifierException;

public class Project {

    private String id;
    private String name;

    public Project(String id, String name) throws Exception {
        setId(id);
        setName(name);
    }

    public Project(String id) throws Exception {
        setId(id);
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
}
