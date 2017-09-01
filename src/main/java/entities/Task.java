package entities;

import enums.Status;

public class Task extends Effort {

    private final String NAME_PREFIX = "Task ";

    private Project project;
    private static int lastTaskId = 1;
    private int id;
    private String name;


    Task(Project project) {
        super(project);
        id = lastTaskId;
        name = NAME_PREFIX + lastTaskId;
        lastTaskId ++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
