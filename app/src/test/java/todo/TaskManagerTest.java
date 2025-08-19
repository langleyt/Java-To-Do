package todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class TaskManagerTest {

    @Test
    public void testAddTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Test Task");
        manager.addTask(task);
        assertTrue(manager.getTasks().contains(task));
    }

    @Test
    public void testRemoveTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Test Task");
        manager.addTask(task);
        manager.removeTask(0);
        assertFalse(manager.getTasks().contains(task));
        System.out.println("Task removed successfully.");
    }

    @Test
    public void testGetTasks() {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        manager.addTask(task1);
        manager.addTask(task2);
        List<Task> tasks = manager.getTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }
}
