/*
 * Base class for all game objects.
 * All game objects have an ID.
 * All game objects have a name.
 * Creates a log entry when created.
 * @author:  JustAKuba
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
