/*
Base class for all game objects
Implemets creation logging
Implements object ID
 */

public abstract class GameObject {
    //Declare variables
    private static int ObjectIdCounter = 0;
    public int objectID = ObjectIdCounter++;


    public GameObject() {
        //Log
        Log.log("", "Created " + this.getClass() + "(" + objectID + ")", LogType.DEBUG, LogFormat.INFO);
    }


}
