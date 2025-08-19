package todo;
public class Task {
    private String name;
    private String description;
    private boolean completed;

    public Task(String name) {
        this(name, "");
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}
