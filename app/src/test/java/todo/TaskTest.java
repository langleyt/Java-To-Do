package todo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testTaskCreation() {
        Task task = new Task("Test Task");
        assertEquals("Test Task", task.getName());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testTaskCompletion() {
        Task task = new Task("Test Task");
        task.markCompleted();
        assertTrue(task.isCompleted());
    }
}
