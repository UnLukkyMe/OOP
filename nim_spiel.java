package src;

import java.util.Random;
import java.util.Scanner;

/**
 * The {@code nim_spiel} class represents a game of Nim between a player and a
 * computer.
 * In this game, players take turns removing stones from a pile, with the goal
 * of
 * forcing the opponent to remove the last stone.
 * It takes care of the initialization of the values, controlling the gameflow
 * as well as the finishing conditions.
 * 
 * @author Aaron Masur
 */
public class nim_spiel {
    /**
     * Parameters of the class
     */
    private int steine_im_haufen;
    private int dran = 0;
    private spieler s1;
    private computer c1;
    private int start_spieler;
    private int spieler_nimmt;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new instance of the Nim game.
     * Prompts the user for their name and prints the game rules.
     */
    public nim_spiel() {
        s1 = new spieler();
        c1 = new computer();
        System.out.println("Wie ist dein Name?: ");
        s1.setName(scanner.nextLine());
        printRegeln();
    }

    /**
     * Starts the game of Nim.
     * Initializes game values and runs the game loop until the stone pile is empty.
     */
    public void starteSpiel() {
        initialisiereWerte();
        while (steine_im_haufen > 0) {
            turn();
        }
        abschluss();
    }

    /**
     * Initializes the game values such as the number of stones in the pile
     * and the starting player.
     */
    public void initialisiereWerte() {
        steine_im_haufen = randInt(20, 30);
        start_spieler = randInt(0, 1); // bei 0 fängt Spieler an, bei 1 fängt Computer an
        if (start_spieler == 0) {
            System.out.println(s1.getName() + " beginnt!");
        } else {
            System.out.println("Computer beginnt!");
        }
        dran = 0;
    }

    /**
     * Executes a turn in the game.
     * Alternates between player and computer turns, allowing them to remove stones
     * from the pile according to the game rules.
     */
    public void turn() {
        if (aktuellerSpieler().equals(s1.getName())) { // Spieler ist dran
            System.out.println("-------------------------------------------------------------\n"
                    + s1.getName() + ", du bist an der Reihe:\n"
                    + "Steine im Haufen: " + steine_im_haufen);

            spieler_nimmt = s1.takeInput(steine_im_haufen);

            steine_im_haufen -= spieler_nimmt;
            System.out.println("----------------------------------------------------------");
        } else { // Computer ist dran
            System.out.println("------------------------------------------------------------\n"
                    + "Computer spielt...\n"
                    + "Steine im Haufen: " + steine_im_haufen);

            int temp = c1.getSteine(steine_im_haufen);
            steine_im_haufen -= temp;
            System.out.println("Der Computer nimmt " + temp + " Steine vom Haufen");

            System.out.println("----------------------------------------------------------");
        }
        dran++;
    }

    /**
     * Generates a random integer between the specified minimum and maximum values.
     * 
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return A random integer within the specified range.
     */
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Retrieves the current number of stones in the pile.
     * 
     * @return The number of stones in the pile.
     */
    public int getSteineImHaufen() {
        return steine_im_haufen;
    }

    /**
     * Sets the number of stones in the pile to the specified value.
     * 
     * @param n The new number of stones in the pile.
     */
    public void setSteineImHaufen(int n) {
        steine_im_haufen = n;
    }

    /**
     * Prints the game rules.
     */
    public void printRegeln() {
        System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Hallo " + s1.getName()
                + ", du spielst 'nim-spiel' gegen den Computer.\nWähle im folgenden 1-3 Steine, die du vom Steinhaufen nehmen möchtest, sorge dafür, dass der Computer den letzten Stein nehmen muss.\nDer Spieler den den letzten Stein vom Haufen nimmt verliert. Viel Erfolg!");
        System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Displays the game result and prompts the player for a new round.
     */
    public void abschluss() {
        String entscheidung = "";
        dran--; // WICHTIG weil dran nach ende des letzten turns noch einmal erhöht wird, somit
                // würtde der falsche spieler gewinnen
        if (aktuellerSpieler().equals("Computer")) {
            s1.setWins(s1.getWins() + 1);
            System.out.println("Herzlichen Glückwunsch " + s1.getName()
                    + " du hast gewonnen! Dir wird 1 Sieg angerechnet: " + s1.getName() + ": " + s1.getWins()
                    + " vs. Computer: " + c1.getWins() + "\nMöchtest du noch eine Runde spielen?: (Ja/Nein)");
        } else {
            c1.setWins(c1.getWins() + 1);
            System.out.println("Du hast verloren! " + s1.getName() + ": " + s1.getWins() + " vs. Computer: "
                    + c1.getWins() + "\nMöchtest du noch eine Runde spielen? (Ja/Nein)");
        }
        entscheidung = scanner.nextLine();
        if (entscheidung.equals("Ja") || entscheidung.equals("ja")) {
            starteSpiel();
        }
    }

    /**
     * Determines the current player.
     * 
     * @return The name of the current player.
     */
    public String aktuellerSpieler() {
        if ((start_spieler == 0 && dran % 2 == 0) || (start_spieler == 1 && dran % 2 != 0)) {
            return s1.getName();
        } else {
            return "Computer";
        }
    }
}
