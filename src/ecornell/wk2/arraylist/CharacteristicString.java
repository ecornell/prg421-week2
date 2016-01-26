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


    @Override
    public String getValue() {
        return (String) value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
