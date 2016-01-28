/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 */
package ecornell.wk2.arraylist;

/**
 * Base Characteristic Object
 */
abstract public class Characteristic {

    /**
     * Characteristic name
     */
    protected String name;

    /**
     * Generic characteristic value
     */
    protected Object value;

    /**
     * Verb value used to describe characteristic (examples: Is a, Can)
     */
    protected String verb;

    /**
     * Default constructor
     * @param name Characteristic name
     */
    public Characteristic(String name) {
        this.name = name;
    }

    /**
     * @return Characteristic name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Characteristic value
     */
    abstract Object getValue();

    /**
     * @return Verb value used to describe characteristic
     */
    public String getVerb() {
        return verb;
    }

    /**
     * @return Custom string value on object variables
     */
    @Override
    public String toString() {
        return getName() + " " + getVerb() + " " + getValue();
    }

}
