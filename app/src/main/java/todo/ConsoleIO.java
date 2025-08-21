package todo;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private static final Scanner scanner = new Scanner(System.in);

    private String outlog = "";

    public ConsoleIO() {}

    /**
     * Sends a message to the console and appends it to the output log.
     * 
     * @param s the message to display.
     */
    public void sendOutput(String s) {
        if (!s.equals("")) {
            outlog += s;
        }
        outlog += "\n";
        System.out.println(s);
    }

    /**
     * Reads a line of input from the console.
     * 
     * @return the input line as a String.
     */
    public String readInput() {
        return scanner.nextLine();
    }

    /**
     * Returns the log of all output messages sent to the console.
     * 
     * @return the output log as a String.
     */
    public String getOutlog() {
        return outlog;
    }
}
