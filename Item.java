public class Item {
    //Declare variables
    private String name;
    //Declare constructor with name
    public Item(String name) {
        this.name = name;
        this.value = value;


        //Log
        Log.log("", this.getClass() + " named: " + name + "(" + objectID + ")", LogType.DEBUG, LogFormat.INFO);
    }

    //GETTERS AND SETTERS//

    public String getObjectIdentity() {
        return name + "(" + objectID + ")";
    }

    //Create method to get name
    public String getName() {
        return name;
    }
    //Create method to get value
    public int getValue() {
        return value;
    }
    //Create method to set name
    public void setName(String n) {
        name = n;
        Log.log("", name + " set name to " + n, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set value
    public void setValue(int v) {
        value = v;
        Log.log("", name + " set value to " + v, LogType.DEBUG, LogFormat.INFO);
    }
}
