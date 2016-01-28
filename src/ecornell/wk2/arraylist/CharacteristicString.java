/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 */
package ecornell.wk2.arraylist;

/**
 * Characteristic object that has a String value (Yes/No or True/False)
 */
public class CharacteristicString extends Characteristic {

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
