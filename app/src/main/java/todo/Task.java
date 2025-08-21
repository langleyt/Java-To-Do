package todo;
public class Task {
    private String name;
    private String description;
    private boolean completed;

    /**
     * Constructs a new Task with the given name and an empty description.
     * The task is initially not completed.
     *
     * @param name the name of the task
     */
    public Task(String name) {
        this(name, "");
    }

    /**
     * Constructs a new Task with the given name and description.
     * The task is initially not completed.
     *
     * @param name the name of the task
     * @param description the description of the task
     */
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the task.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the task is completed.
     *
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.completed = true;
    }
}
