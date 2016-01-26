/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 */
package ecornell.wk2.arraylist;

/**
 * Created by ecornell on 1/25/2016.
 */
public class CharacteristicString extends Characteristic {

    public CharacteristicString(String name, String verb) {
        super(name);
        this.name = name;
        this.verb = verb;
    }

    public String getValue() {
        return (String) value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
