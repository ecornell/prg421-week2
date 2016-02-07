/**
 * Title:          ArrayLists (Animal Catalog) - Week 3 Team Improvements
 * Author:         Team B - ( Elijah Cornell / Eric Landeis / Gordon Doskas /
 *                          James Rippon / Joseph Hart / Keith Green / Lance Branford )
 * Creation Date:  2016-02-05
 * Class:          PRG/421 - Roland Morales
 */

import java.io.Serializable;

/**
 * Characteristic object that has a Boolean value (Yes/No or True/False)
 */
public class CharacteristicBoolean extends Characteristic implements Serializable {

    static final long serialVersionUID = 1L;

    /**
     * Negatived verb value used to describe characteristic (examples: Is not a, Cannot)
     */
    private String negativeVerb;

    /**
     * @param name Characteristic name
     * @param trueVerb Verb to describe characteristic
     * @param negativeVerb Negative form of verb used to describe characteristic
     */
    public CharacteristicBoolean(String name, String trueVerb, String negativeVerb) {
        super(name);
        this.verb = trueVerb;
        this.negativeVerb = negativeVerb;
    }

    /**
     * @return Boolean characteristic value
     */
    @Override
    public Boolean getValue() {
        return (Boolean) value;
    }

    /**
     * @param value Boolean characteristic value
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * @return Custom string value on object variables
     */
    @Override
    public String toString() {

        return (getValue() ? verb : negativeVerb) + " " + getName();

    }

}
