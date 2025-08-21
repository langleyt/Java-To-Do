package todo;

/**
 * This class manages a single instance of the IO interface, ensuring consistent 
 * input/output handling across the game. It allows setting and retrieving the 
 * IO instance used for player interaction.
 */

public class IOprovider {

    /**
     * The singleton instance of the IO interface.
     */
    private static IO ioInstance;


    /**
     * Sets the IO instance to be used for input and output operations in the game.
     * 
     * @param io the IO implementation instance (e.g., console-based or GUI-based).
     */
    public static void setIO(IO io) {
        ioInstance = io;
    }

     /**
     * Retrieves the current IO instance.
     * 
     * @return the IO instance used for input and output operations.
     * @throws IllegalStateException if the IO instance has not been set.
     */
    public static IO getIO() {
        if (ioInstance == null) {
            throw new IllegalStateException("IO instance not set. Please set the IO instance before using it.");
        }
        return ioInstance;
    }
}