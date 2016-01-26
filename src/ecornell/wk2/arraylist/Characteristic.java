/**
 * Title:          Week 2 - ArrayLists (Animal Catalog)
 * Author:         Elijah Cornell
 * Creation Date:  2016-01-25
 * Class:          PRG/421 - Roland Morales
 */
package ecornell.wk2.arraylist;

abstract public class Characteristic {

    protected String name;
    protected Object value;

    protected String verb;

    public Characteristic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract Object getValue();

    public String getVerb() {
        return verb;
    }

    @Override
    public String toString() {
        return getName() + " " + getVerb() + " " + getValue();
    }

}
