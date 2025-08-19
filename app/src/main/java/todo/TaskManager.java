package todo;

import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }

    public boolean removeTask(int task_index) {
        if (task_index >= 0 && task_index < tasks.size()) {
            tasks.remove(task_index);
            return true;
        }
        return false;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
