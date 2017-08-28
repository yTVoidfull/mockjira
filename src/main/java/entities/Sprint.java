package entities;


public class Sprint extends PlannedEffort {


    private Project project;

    private Sprint(Project project) {
        super();
        this.project = project;
    }

    public static Sprint createSprintFor(Project p){
        return new Sprint(p);
    }

}
