package todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


public class ConsoleUITest {
    private ConsoleUI consoleUI;
    private TestIO io;

    @BeforeEach
    void setUp() {
        consoleUI = new ConsoleUI(new TestIO());
        io = (TestIO) IOprovider.getIO();
    }

    @AfterEach
    void tearDown() {
        io.clearLog();
    }

    @Test
    public void testLoadAndViewTasks() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("2");
        inputs.add("Feed Fred");
        inputs.add("Feed Fred description");
        inputs.add("1");
        inputs.add("3");
        inputs.add("1");
        inputs.add("4");
        
        io.setInputs(inputs);
        // just viewing test in report
        consoleUI.start();
        
        String outlog = io.getLog();
        ArrayList<String> lines = new ArrayList<>(List.of(outlog.split("\n")));

        // check to find name of loaded task
        boolean found = false;
        for (String line : lines) {
            if (line.contains("Feed Fred")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testAddTask() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("2"); // add task option
        inputs.add("example task 1");
        inputs.add("example task 1 description");
        inputs.add("1"); // view tasks option
        inputs.add("3"); // remove task
        inputs.add("1"); // remove task (task number)
        inputs.add("4"); // exit
        io.setInputs(inputs);
        consoleUI.start();

        String outlog = io.getLog();
        ArrayList<String> lines = new ArrayList<>(List.of(outlog.split("\n")));

        // Check if the new task was added and displayed
        boolean found = false;
        for (String line : lines) {
            if (line.contains("example task 1") || line.contains("example task 1 description")) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }
}