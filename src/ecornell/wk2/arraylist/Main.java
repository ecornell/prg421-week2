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
 *     -> Add animal
 *     -> Edit animal
 *     -> Delete animal
 *     -> List animals
 *
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

                ui.displayPrompt(c.getVerb() + " " + c.getName() + "? (y/n) : ");

                String newValueString = ui.readInputString();
                if (newValueString.trim().length() > 0) {
                    ((CharacteristicBoolean) c).setValue(newValueString.equalsIgnoreCase("y"));
                }

            } else if (c instanceof CharacteristicString) {

                ui.displayPrompt( c.getName() + " " + c.getVerb() +"? : ");

                ((CharacteristicString) c).setValue(ui.readInputString());

            }

        }

        animalList.add(animal);
    }

    private void listAnimals() {
        for (Animal animal : animalList) {

            ui.display(animal.getName());

            for (Characteristic c : animal.getCharacteristicList()) {

                ui.display(" - " + c.toString());

            }

            ui.spacer();

        }
    }

    private void deleteAnimal() {
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            ui.display((i+1) + " : " + animal.getName());
        }

        ui.spacer();

        int inputNumber = 0;
        do {
            ui.displayPrompt("Enter # to delete: ");

            try {
                inputNumber = ui.readInputInt();
            } catch (NumberFormatException nfe) {
                ui.displayError("Invalid number entered");
            }

        } while (inputNumber == 0);

        int n = ui.readInputInt();

        ui.spacer();

        animalList.remove(n);
    }

    private void editAnimal() {
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            ui.display((i+1) + " : " + animal.getName());
        }

        ui.spacer();

        int inputNumber = 0;
        do {
            ui.displayPrompt("Enter # to edit: ");

            try {
                inputNumber = ui.readInputInt();
            } catch (NumberFormatException nfe) {
                ui.displayError("Invalid number entered");
            }

        } while (inputNumber == 0);

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

                ui.displayPrompt(c.getVerb()
                        + " " + c.getName() + "? (y/n) ["
                        + (((CharacteristicBoolean) c).getValue() ? "y" : "n") + "]: ");

                String newValueString = ui.readInputString();
                if (newValueString.trim().length() > 0) {
                    ((CharacteristicBoolean) c).setValue(newValueString.equalsIgnoreCase("y"));
                }

            } else if (c instanceof CharacteristicString) {

                ui.displayPrompt( c.getName() + " " + c.getVerb() +"? [" + c.getValue() + "] : ");

                String newValueString = ui.readInputString();
                if (newValueString.trim().length() > 0) {
                    ((CharacteristicString) c).setValue(newValueString);
                }

            }

        }
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
