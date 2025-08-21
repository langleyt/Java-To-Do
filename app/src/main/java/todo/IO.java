package todo;
/**
 * Interface for handling input and output operations.
 * It defines methods to display messages and read player input,
 * ensuring a consistent way to manage interaction between players and the game.
 */
public interface IO {

    /**
     * Displays a message or output to the player.
     * 
     * @param s the message to be displayed (e.g., game prompts, etc.).
     */
    public void sendOutput(String s);

    /**
     * Reads and returns input provided by the player.
     * 
     * @return a String representing the player's input.
     */
    public String readInput();
}