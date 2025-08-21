package todo;

import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    /**
     * Constructs a new TaskManager with an empty list of tasks.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        // loadTasks();
    }

    /**
     * Creates a new task with the given name and description, and adds it to the task list.
     *
     * @param name the name of the new task
     * @param description the description of the new task
     */
    public void newTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }

    /**
     * Adds an existing Task object to the task list.
     *
     * @param task the Task object to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes the task at the specified index from the task list.
     *
     * @param task_index the index of the task to be removed
     * @return true if the task was successfully removed, false if the index is invalid
     */
    public boolean removeTask(int task_index) {
        if (task_index >= 0 && task_index < tasks.size()) {
            tasks.remove(task_index);
            return true;
        }
        return false;
    }

    /**
     * Returns the list of all tasks.
     *
     * @return the list of tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
