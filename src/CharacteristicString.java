/**
 * Title:          ArrayLists (Animal Catalog) - Week 3 Team Improvements
 * Author:         Team B - ( Elijah Cornell / Eric Landeis / Gordon Doskas /
 *                          James Rippon / Joseph Hart / Keith Green / Lance Branford )
 * Creation Date:  2016-02-05
 * Class:          PRG/421 - Roland Morales
 */

import java.io.Serializable;

/**
 * Characteristic object that has a String value (Yes/No or True/False)
 */
public class CharacteristicString extends Characteristic implements Serializable {

    /**
     * @param name Characteristic name
     * @param verb  Verb to describe characteristic
     */
    public CharacteristicString(String name, String verb) {
        super(name);
        this.name = name;
        this.verb = verb;
    }

    /**
     * @return String characteristic value
     */
    public String getValue() {
        return (String) value;
    }

    /**
     * @param value String characteristic value
     */
    public void setValue(String value) {
        this.value = value;
    }


}
