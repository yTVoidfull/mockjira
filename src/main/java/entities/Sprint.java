package entities;


import java.util.List;

public class Sprint extends Effort {

    private List<Task> tasks;

    Sprint(Project project) {
        super(project);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
