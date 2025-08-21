package todo;

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

    @Test
    public void testViewTasks() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("4");
        inputs.add("1");
        inputs.add("5");
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
        System.out.println("Output log: " + outlog);

        assertTrue(found);
    }
}