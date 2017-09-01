package entities;

import exceptions.InvalidProjectIdentifierException;

import java.util.ArrayList;
import java.util.List;

public class Project extends Effort {

    private String id;
    private String name;
    private int duration;
    private List<Sprint> sprints = new ArrayList<Sprint>();
    private List<Issue> issues = new ArrayList<Issue>();
    private List<Task> tasks = new ArrayList<Task>();

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

    public Sprint createSprint(){
        Sprint s = new Sprint(this);
        sprints.add(s);
        return s;
    }

    public Issue createIssue(){
        Issue i = new Issue(this);
        issues.add(i);
        return i;
    }

    public Task createTask(Project project) {
        Task t = new Task(this);
        tasks.add(t);
        return t;
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

    public List<Issue> getIssues() {
        return issues;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
