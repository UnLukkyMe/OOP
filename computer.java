package src;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code computer} class represents a computer object that keeps track of
 * its wins and holds a Map with predifined integers, to help decision-making
 * while playing.
 * <p>
 * This class provides methods to set and get the number of wins, as well as
 * takinjg care of the decision process whilst playing.
 * 
 * @author Aaron Masur.
 */
public class computer {
    /**
     * The HashMap to store the Computers actions
     */
    private Map<Integer, Integer> map;
    /**
     * The number of wins achieved by the computer.
     */
    private int wins = 0;

    /**
     * Constructs a new computer object. Initializes a HashMap and sets its values
     * using the setMapValues method (to have higher reusability in case of trying
     * different strategic approaches).
     */
    public computer() {
        map = new HashMap<Integer, Integer>();

        setMapValues();
    }

    /**
     * Fills the HashMap with a predefined mapping of integers (keys ranging from
     * 1-30), which
     * is used to determine the number stones to take from the pile, based on the
     * amount left in it.
     * 
     * Sets the values of the internal HashMap according to a specific pattern.
     * The pattern involves setting the value to 1 for every fourth key starting
     * from 1, and setting other keys to the difference between the key and the
     * nearest multiple of 4.
     * For example, keys 1, 5, 9, 13, 17, etc., have their values set to 1, while
     * other keys have their values set to the difference between the key and the
     * nearest multiple of 4, to achieve the strategically best plays.
     * 
     */
    public void setMapValues() {
        map.put(1, 1);

        int j = 1;
        int k = j + 4;
        for (int i = 2; i < 31; i++) {
            if (i == k) {
                // if (i == 5 || i == 9 || i == 13 || i == 17 || i == 21 || i == 25 || i == 29)
                // {
                map.put(i, 1);
                j += 4;
                k += 4;
            } else {
                map.put(i, i - j);
            }
        }
    }

    /**
     * Sets the number of wins for the computer.
     *
     * @param n the number of wins to set
     */
    public void setWins(int n) {
        wins = n;
    }

    /**
     * Gets the number of wins for the computer.
     *
     * @return the number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns the strategically best amount of stones to take from the pile,
     * regarding the amount left in it.
     * 
     * @param steine_im_haufen The number of stones currently in the pile
     * @return The number of stones to take from the pile
     */
    public int getSteine(int steine_im_haufen) {
        return map.get(steine_im_haufen);
    }

}
