/*
    * This class represents a decision that can be made by the user.
    * It contains a description of the decision and an action to be
    * executed when the decision is made.
    * Action has to be input of a lambda function.
    * @author: JustAKuba
 */
public class Decision {
    private String description;
    private Runnable action;

    public Decision(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        action.run();
    }
}






