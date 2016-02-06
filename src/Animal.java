/**
 * Title:          ArrayLists (Animal Catalog) - Week 3 Team Improvements
 * Author:         Team B - ( Elijah Cornell / Eric Landeis / Gordon Doskas /
 *                          James Rippon / Joseph Hart / Keith Green / Lance Branford )
 * Creation Date:  2016-02-05
 * Class:          PRG/421 - Roland Morales
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Animal object which contains a list of characteristic values
 */
public class Animal implements Serializable {

    /**
     * Animal name
     */
    private String name;

    /**
     * Listing the animal's characteristic values
     */
    private List<Characteristic> characteristicList;

    /**
     * Default constructor - Sets list known characteristic types
     */
    public Animal() {

        // Set default characteristics

        characteristicList = new ArrayList<Characteristic>();

        characteristicList.add(new CharacteristicString("Color", "is"));
        characteristicList.add(new CharacteristicBoolean("Fly", "Can", "Cannot"));
        characteristicList.add(new CharacteristicBoolean("Swim", "Can", "Cannot"));
        characteristicList.add(new CharacteristicBoolean("Vertebrate", "Is a", "Is not a"));

    }

    /**
     * @return Animal name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Animal name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Listing of the animal's characteristic values
     */
    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }

    public static Comparator<Animal> nameComparator = new Comparator<Animal>() {
      public int compare(Animal a1, Animal a2) {
        return a1.getName().toUpperCase().compareTo(a2.getName().toUpperCase());
      }
    };

    public static Comparator<Animal> colorComparator = new Comparator<Animal>() {
      public int compare(Animal a1, Animal a2) {
        String v1 = "";
        String v2 = "";

        for(Characteristic chr : a1.getCharacteristicList())
        {
          if (chr.getName().equals("Color"))
          {
            v1 = (String)chr.getValue();
          }
        }
        for(Characteristic chr : a2.getCharacteristicList())
        {
          if (chr.getName().equals("Color"))
          {
            v2 = (String)chr.getValue();
          }
        }
        return v1.toUpperCase().compareTo(v2.toUpperCase());
      }
    };
}
