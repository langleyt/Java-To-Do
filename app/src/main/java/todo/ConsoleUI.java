package todo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConsoleUI {
    private IO io;
    private TaskManager taskManager;
    private boolean running;

    private static final String TASKS_FILE = "src/main/java/resources/tasks.json";
    private Gson gson = new Gson();
    
    /**
     * Constructor to create a Console User Interface for the to-do list application.
     * @param io the IO implementation to be used for input and output operations.
     */
    public ConsoleUI(IO io) {
        IOprovider.setIO(io);
        this.io = IOprovider.getIO();
        taskManager = new TaskManager();
        running = true;
    }


    /**
     * Loads tasks from a JSON file into the tasks list.
     * If the file is not found or an error occurs, initializes an empty task list.
     */
    private void loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (FileReader reader = new FileReader(TASKS_FILE)) {
            tasks = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (tasks == null) tasks = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
            tasks = new ArrayList<>();
        }
        for (Task task : tasks) {
            taskManager.addTask(task);
        }
    }


    /**
     * Displays the list of current tasks to the console along with their descriptions.
     */
    private void viewTasks() { 
        io.sendOutput("Tasks:");
        for (int i = 0; i < taskManager.getTasks().size(); i++) {
            Task task = taskManager.getTasks().get(i);
            io.sendOutput((i + 1) + "." + task.getName() + "\n    - " + task.getDescription());
        }
    }

    /**
     * Creates a new task by prompting the user for a name and description,
     * then adds it to the task manager.
     */
    private void newTask() {
        io.sendOutput("Enter task name: ");
        String name = io.readInput();
        io.sendOutput("Enter task description: ");
        String desc = io.readInput();
        taskManager.newTask(name, desc);
        io.sendOutput("Task added.");
    }

    /**
     * Removes a task by its number after prompting the user.
     * Validates the input and provides feedback on the operation's success.
     */
    private void removeTask() {
        io.sendOutput("Enter task number to remove: ");
        try {
            int num = Integer.parseInt(io.readInput());
            if (taskManager.removeTask(num - 1)) {
                io.sendOutput("Task removed.");
            } else {
                io.sendOutput("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            io.sendOutput("Please enter a valid number.");
        }
    }

    /**
     * Exits the application by setting the running flag to false
     * and displaying a goodbye message.
     */
    private void exit() {
        running = false;
        io.sendOutput("Goodbye!");
    }

    /**
     * Prompts the user to select an action based on their input.
     * Executes the corresponding method for the chosen action.
     *
     * @param decision the user's menu choice
     */
    private void promptAction(String decision) {
        if (decision.equals("1")) {
            viewTasks();
        } else if (decision.equals("2")) {
            newTask();
        } else if (decision.equals("3")) {
            removeTask();
        } else if (decision.equals("4")) {
            loadTasks();
        } else if (decision.equals("5")) {
            exit();
        }
    }

    /**
     * Prints the menu options to the user.
     */
    public void viewOptions() {
        io.sendOutput("1. View Tasks");
        io.sendOutput("2. Add Task");
        io.sendOutput("3. Remove Task");
        io.sendOutput("4. Load Tasks");
        io.sendOutput("5. Exit");
        io.sendOutput("Choose an option: ");
    }

    /**
     * Starts the main loop of the console UI, handling user input and actions.
     */
    public void start() {
        while (running) {
            io.sendOutput("\n--- To-Do List ---");
            viewOptions();
            String choice = io.readInput();

            try {
                String decision = choice.strip();
                if (Integer.parseInt(decision) < 1 || Integer.parseInt(decision) > 5) {
                    io.sendOutput("Please choose a valid option.");
                    continue;
                }
                promptAction(decision);
            } catch (NumberFormatException e) {
                io.sendOutput("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        IO consoleIO = new ConsoleIO();
        ConsoleUI gui = new ConsoleUI(consoleIO);
        gui.start();
    }
}
