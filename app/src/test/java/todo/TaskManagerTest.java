package todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class TaskManagerTest {
    private TaskManager tm1 = new TaskManager();
    private Task testTask = new Task("Test Task");


    @AfterEach
    void tearDown() {
        tm1 = new TaskManager();
    }

    @Test
    public void testAddTask() {
        tm1.addTask(testTask);
        assertTrue(tm1.getTasks().contains(testTask));
    }

    @Test
    public void testRemoveTask() {
        tm1.addTask(testTask);
        tm1.removeTask(0);
        assertFalse(tm1.getTasks().contains(testTask));
        System.out.println("Task removed successfully.");
    }

    @Test
    public void testGetTasks() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        tm1.addTask(task1);
        tm1.addTask(task2);
        List<Task> tasks = tm1.getTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }
}
