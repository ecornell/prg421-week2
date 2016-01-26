package ecornell.wk2.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 * <p/>
 * Program Requirements:
 * <p/>
 * Key parts:
 * - Add, edit, delete different types of animals
 * - Select an animal, and the corresponding characteristics will be displayed
 * (such as color, vertebrate or invertebrate, can swim, etc.)
 * -The program must use ArrayList(s) to work with these animal objects.
 * <p/>
 * Must demonstrate the use of an ArrayList
 * <p/>
 * Program Flow:
 * Display a main menu
 * -> Add animal
 * -> Edit animal
 * -> Delete animal
 * -> List animals
 * <p/>
 * Input: Console
 * Output: Console
 */
public class Main {

    private final UI ui = UI.getInstance();

    private List<Animal> animalList;

    public Main() {
        animalList = new ArrayList<Animal>();
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

            ui.display("A: Add new animal");
            ui.display("E: Edit an animal");
            ui.display("D: Delete an animal");
            ui.display("L: List entire catalog");
            ui.display("X: Exit");
            ui.spacer();
            ui.displayPrompt("Menu selection (A/E/D/L/X) : ");

            menuSelection = ui.readInputString();

            if (menuSelection.equalsIgnoreCase("A")) {

                ui.displayTitle("Add New Animal");

                addAnimal();

            } else if (menuSelection.equalsIgnoreCase("E")) {

                ui.displayTitle("Edit an Animal");

                editAnimal();

            } else if (menuSelection.equalsIgnoreCase("D")) {

                ui.displayTitle("Delete an Animal");

                deleteAnimal();

            } else if (menuSelection.equalsIgnoreCase("L")) {

                ui.displayTitle("List of Entire Animal Catalog");

                listAnimals();

            }

        } while (!menuSelection.equalsIgnoreCase("X"));

    }

    private void addAnimal() {
        Animal animal = new Animal();

        ui.displayPrompt("Enter animal name: ");

        animal.setName(ui.readInputString());

        for (Characteristic c : animal.getCharacteristicList()) {

            if (c instanceof CharacteristicBoolean) {

                promptCharBool(c, c.getVerb() + " " + c.getName() + "? (y/n) : ", false);

            } else if (c instanceof CharacteristicString) {

                promptCharString(c, c.getName() + " " + c.getVerb() + "? : ");

            }

        }

        animalList.add(animal);
    }

    private void deleteAnimal() {
        displayNumberedList();

        ui.spacer();

        int inputNumber = promptNumber("Enter # to delete: ");

        ui.spacer();

        animalList.remove(inputNumber);
    }

    private void editAnimal() {
        displayNumberedList();

        ui.spacer();

        int inputNumber = promptNumber("Enter # to edit: ");

        ui.spacer();

        //

        Animal animal = animalList.get(inputNumber - 1);


        ui.displayPrompt("Enter animal name [" + animal.getName() + "] : ");

        String newName = ui.readInputString();
        if (newName.trim().length() > 0) {
            animal.setName(newName);
        }

        for (Characteristic c : animal.getCharacteristicList()) {

            if (c instanceof CharacteristicBoolean) {

                String prompt = String.format("%s %s? (y/n) [%s] : ",
                        c.getVerb(),
                        c.getName(),
                        (((CharacteristicBoolean) c).getValue() ? "y" : "n"));

                promptCharBool(c, prompt, true);

            } else if (c instanceof CharacteristicString) {

                String prompt = String.format("%s %s? [%s] : ",
                        c.getVerb(),
                        c.getName(),
                        c.getValue());

                promptCharString(c, prompt);

            }

        }
    }

    private void displayNumberedList() {
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            ui.display((i + 1) + " : " + animal.getName());
        }
    }

    private int promptNumber(String text) {
        int inputNumber = 0;
        do {
            ui.displayPrompt(text);

            try {
                inputNumber = ui.readInputInt();
            } catch (NumberFormatException nfe) {
                ui.displayError("Invalid number entered");
            }

        } while (inputNumber == 0);
        return inputNumber;
    }

    private void promptCharString(Characteristic c, String prompt) {
        ui.displayPrompt(prompt);

        String newValueString = ui.readInputString();
        if (newValueString.trim().length() > 0) {
            ((CharacteristicString) c).setValue(newValueString);
        }
    }

    private void promptCharBool(Characteristic c, String prompt, boolean allowEmpty) {
        boolean valid = false;
        do {
            ui.displayPrompt(prompt);

            String newValueString = ui.readInputString();
            if (newValueString.trim().length() > 0) {
                if (newValueString.equalsIgnoreCase("y") || newValueString.equalsIgnoreCase("n")) {
                    ((CharacteristicBoolean) c).setValue(newValueString.equalsIgnoreCase("y"));
                    valid = true;
                } else {
                    ui.displayError("Invalid input - Must enter y or n");
                    valid = false;
                }
            } else {
                if (allowEmpty) {
                    valid = true;
                }
            }
        } while (!valid);
    }

    private void listAnimals() {

        if (animalList.size() > 0) {

            for (Animal animal : animalList) {

                ui.display(animal.getName());

                for (Characteristic c : animal.getCharacteristicList()) {

                    ui.display(" - " + c.toString());

                }

                ui.spacer();

            }

        } else {

            ui.display("Catalog is empty");

        }
    }


    /**
     * Main program entry point
     *
     * @param args None
     */
    public static void main(String[] args) {

        Main m = new Main();
        m.mainLoop();

    }

}
