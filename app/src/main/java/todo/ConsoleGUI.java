package todo;

import java.util.Scanner;

public class ConsoleGUI {
    private Scanner scanner;
    private TaskManager taskManager;
    private boolean running;
    
    private void viewTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < taskManager.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + taskManager.getTasks().get(i));
        }
    }

    private void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        taskManager.addTask(name, desc);
        System.out.println("Task added.");
    }

    private void removeTask() {
        System.out.print("Enter task number to remove: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (taskManager.removeTask(num - 1)) {
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void exit() {
        running = false;
        System.out.println("Goodbye!");
    }

    private void promptAction(int decision) {
        if (decision == 1) {
            viewTasks();
        } else if (decision == 2) {
            addTask();
        } else if (decision == 3) {
            removeTask();
        } else if (decision == 4) {
            exit();
        } else {
            System.out.println("Invalid option");
        }
    }

    public ConsoleGUI() {
        scanner = new Scanner(System.in);
        taskManager = new TaskManager();
        running = true;
    }

    public void start() {
        while (running) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            try {
                int decision = Integer.parseInt(choice);
                if (decision < 1 || decision > 4) {
                    System.out.println("Please choose a valid option.");
                    continue;
                }
                promptAction(decision);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ConsoleGUI gui = new ConsoleGUI();
        gui.start();
    }
}
