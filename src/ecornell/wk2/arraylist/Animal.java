/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 */
package ecornell.wk2.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    // ID
    private String name;

    private List<Characteristic> characteristicList;

    public Animal() {

        // Set default characteristics

        characteristicList = new ArrayList<Characteristic>();

        characteristicList.add(new CharacteristicString("Color","is"));
        characteristicList.add(new CharacteristicBoolean("Fly", "Can", "Cannot"));
        characteristicList.add(new CharacteristicBoolean("Swim", "Can", "Cannot"));
        characteristicList.add(new CharacteristicBoolean("Vertebrate", "Is a", "Is not a"));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }
}
