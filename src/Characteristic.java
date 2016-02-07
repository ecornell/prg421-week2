/**
 * Title:          ArrayLists (Animal Catalog) - Week 3 Team Improvements
 * Author:         Team B - ( Elijah Cornell / Eric Landeis / Gordon Doskas /
 *                          James Rippon / Joseph Hart / Keith Green / Lance Branford )
 * Creation Date:  2016-02-05
 * Class:          PRG/421 - Roland Morales
 */

import java.io.Serializable;

/**
 * Base Characteristic Object
 */
abstract public class Characteristic implements Serializable {

    static final long serialVersionUID = 1L;

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
