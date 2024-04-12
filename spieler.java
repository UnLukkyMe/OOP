package src;

import java.util.Scanner;

/**
 * The {@code spieler} class represents a player object that keeps track of
 * their name and wins.
 * <p>
 * This class provides methods to set and get the player's name and number of
 * wins, as well as taking input from the user.
 * 
 * @author Aaron Masur.
 */
public class spieler {
    /**
     * The name of the player.
     */
    private String name;

    /**
     * The number of wins achieved by the player.
     */
    private int wins = 0;

    /**
     * The number of wins achieved by the player.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Takes input from the player, specifying the number of stones to remove from
     * the pile.
     * 
     * @param steine_im_haufen The number of stones currently in the pile.
     * @return The number of stones chosen by the player.
     */
    public int takeInput(int steine_im_haufen) {
        System.out.println("Wie viele Steine möchtest du vom Steinhaufen(" + steine_im_haufen + ") nehmen?: ");
        String zweg = scanner.nextLine();

        while (zweg.charAt(0) != '0' && zweg.charAt(0) != '1' && zweg.charAt(0) != '2' && zweg.charAt(0) != '3'
                && zweg.charAt(0) != '4' && zweg.charAt(0) != '5' && zweg.charAt(0) != '6' && zweg.charAt(0) != '7'
                && zweg.charAt(0) != '8' && zweg.charAt(0) != '9') {
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Ungültige Eingabe '" + zweg + "', bitte wähle eine ganze Zahl (1-3 Steine)");
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            zweg = scanner.nextLine();
        }

        int nimmt = Integer.valueOf(zweg);
        // int nimmt=Integer.valueOf(scanner.nextLine());
        if (steine_im_haufen <= 2 && nimmt > steine_im_haufen) {
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Es sind nur noch " + steine_im_haufen + " Stein/e im Haufen. \nBitte Wähle maximal "
                    + steine_im_haufen + " Stein/e, die du aufheben möchtest.");
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            nimmt = takeInput(steine_im_haufen);
        } else if (nimmt > 3 || nimmt < 1) {
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Ungültige Eingabe, bitte wähle 1-3 Steine");
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            nimmt = takeInput(steine_im_haufen);
        }
        return nimmt;
    }

    /**
     * Sets the name of the player.
     *
     * @param n the name to set
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the number of wins for the player.
     *
     * @param n the number of wins to set
     */
    public void setWins(int n) {
        this.wins = n;
    }

    /**
     * Gets the number of wins for the player.
     *
     * @return the number of wins
     */
    public int getWins() {
        return this.wins;
    }
}
