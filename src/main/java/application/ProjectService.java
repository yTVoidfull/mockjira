package application;

import domain.model.Project;
import domain.model.ProjectCode;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private List<Project> listOfProjects = new ArrayList<>();

    public Project create(ProjectCode projectCode) {
        if(thereIsNo(projectCode)){
            Project p = new Project(projectCode);
            listOfProjects.add(p);
            return p;
        }
        throw new IllegalArgumentException("Project with this code already exists");
    }

    public Project find(ProjectCode projectCode) {
        for(Project p : listOfProjects){
            if(p.getCode().equals(projectCode))
                return p;
        }
        return null;
    }

    public void close(ProjectCode projectCode) {
        find(projectCode).close();
    }

    public boolean thereIsNo(ProjectCode projectCode){
        return find(projectCode) == null;
    }
}
