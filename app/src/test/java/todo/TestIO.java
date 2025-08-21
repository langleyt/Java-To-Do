package todo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestIO implements IO {
    private Queue<String> inputs;
    private String outlog;

    public TestIO(ArrayList<String> newInputs) {
        this();
        setInputs(newInputs);
    }

    public TestIO() {
        inputs = new LinkedList<>();
        outlog = "";
    }

    public void sendOutput(String s) {
        if (!s.equals("")) {
            outlog += s;
        }
        outlog += String.format("%n");
        System.out.println(s);
    }

    public String readInput() {
        return inputs.poll();
    }

    public void setInputs(ArrayList<String> newInputs) {
        for (String i: newInputs) {
            inputs.add(i);
        }
    }

    public String getLog() {
        return outlog;
    }

    public void clearLog() {
        outlog = "";
    }
}
