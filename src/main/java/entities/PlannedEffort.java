package entities;

import enums.Status;

public abstract class PlannedEffort extends Effort{

    private int hoursEstimation;

    public PlannedEffort(Project project) {
        super(project);
    }

    public int getHoursEstimation() {
        return hoursEstimation;
    }

    public void setHoursEstimation(int hoursEstimation) {
        this.hoursEstimation = hoursEstimation;
    }
}
