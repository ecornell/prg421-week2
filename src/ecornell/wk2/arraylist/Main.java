package ecornell.wk2.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 *
 * Program Requirements:
 *
 * Key parts:
 * - Add, edit, delete different types of animals
 * - Select an animal, and the corresponding characteristics will be displayed
 * (such as color, vertebrate or invertebrate, can swim, etc.)
 * -The program must use ArrayList(s) to work with these animal objects.
 *
 * Must demonstrate the use of an ArrayList
 *
 * Program Flow:
 *   Display a main menu
 *     ->
 *
 * Input: Console
 * Output: Console
 */
public class Main {

    private final UI ui = UI.getInstance();


    private List<Animal> animalCatalog;


    public Main() {

        animalCatalog = new ArrayList<Animal>();

    }


    /**
     * Main program loop
     */
    private void mainLoop() {

        ui.display("========================================");
        ui.display("|             Animal Catalog           |");
        ui.display("|    PRG-421 - Wk2 - Elijah Cornell    |");
        ui.display("========================================");

        String menuSelection;

        do {

            ui.displayTitle("Main Menu");

            ui.display("A: Assign runner to lane");
            ui.display("L: List current lane assignments");
            ui.display("R: Reset lane assignments");
            ui.display("X: Exit");
            ui.displayPrompt("Menu selection (A/L/R/X) : ");


            menuSelection = ui.readInputString();

            if (menuSelection.equalsIgnoreCase("A")) {


            }

        } while (!menuSelection.equalsIgnoreCase("X"));

    }






    /**
     * Main program entry point
     * @param args None
     */
    public static void main(String[] args) {

        Main m = new Main();
        m.mainLoop();

    }

}
