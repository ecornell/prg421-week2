package ecornell.wk2.arraylist;

/**
 * Created by eli on 1/25/16.
 */
public class CharacteristicBoolean extends Characteristic {

    private String negativeVerb;

    public CharacteristicBoolean(String name, String trueVerb, String negativeVerb) {
        super(name);

        this.verb = trueVerb;
        this.negativeVerb = negativeVerb;
    }

    @Override
    public Boolean getValue() {
        return (Boolean) value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return (getValue() ? verb : negativeVerb) + " " + getName();

    }


}
