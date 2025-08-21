package todo;

import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class TaskManager {
    private List<Task> tasks;
    
    private static final String TASKS_FILE = "src/main/java/resources/tasks.json";
    private Gson gson = new Gson();

    /**
     * Constructs a new TaskManager with an empty list of tasks.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
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
        saveTasks(); // Update JSON file after adding a new task
    }

    /**
     * Saves the current list of tasks to a JSON file.
     */
    private void saveTasks() {
        try (FileWriter writer = new FileWriter(TASKS_FILE)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private void loadTasks() {
        try (FileReader reader = new FileReader(TASKS_FILE)) {
            tasks = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (tasks == null) tasks = new ArrayList<>();
        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }

    /**
     * Adds an existing Task object to the task list. Used for loading tasks from the JSON file.
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
            saveTasks(); // Update JSON file after removing a task
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
