/*
 * Class Item represents an item that can be picked up and used by a character
 * Class is a subclass of GameObject
 * Class is a superclass of Weapon
 * Class has name and value
 * @author:  JustAKuba
 */

public abstract class Item extends GameObject {
    //Declare variables
    private String name;
    private int value;
    //Declare constructor with name
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Item(int value) {
        this.value = value;
        //this.name ="";
    }

    //GETTERS AND SETTERS//

    public String getObjectIdentity() {
        return name + "(" + objectID + ")";
    }

    //Create method to get name
    public String getName() {
        Log.log("", this.getClass() + " named: " + name + "(" + objectID + ")", LogType.DEBUG, LogFormat.INFO);
        return name;
    }
    //Create method to get value
    public int getValue() {
        return value;
    }
    //Create method to set name
    public void setName(String n) {
        name = n;
        Log.log("", this.getClass() + "("+ this.objectID + ")" + " set name to " + n, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set value
    public void setValue(int v) {
        value = v;
        Log.log("", this.getObjectIdentity() + " set value to " + v, LogType.DEBUG, LogFormat.INFO);
    }
}
