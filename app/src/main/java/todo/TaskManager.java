package todo;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
        // loadTasks();
    }

    public void newTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }

    public void addTask(Task task) {
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
