package board;

public class BoardUtils {
    /**
     * Check if coordinate on board is valid
     * @param coordinates
     * @return true if valid, false otherwise
     */
    public static boolean isValidCoordinates(int coordinates) {
        return coordinates >= 1 && coordinates <= 64;
    }
}
