import java.util.ArrayList;

/*
    * This class represents a menu that can be displayed to the user.
    * It contains a list of decisions that can be made by the user.
    * @author: JustAKuba
 */
public class Menu extends GameObject {
    private ArrayList<Decision> decisions = new ArrayList<Decision>();
    private String description;

    public Menu(ArrayList<Decision> decisions) {
        this.description = "";
        this.decisions = decisions;
        Log.log("", "Menu(" + this.objectID + ") created", LogType.DEBUG, LogFormat.INFO);
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<Decision> getDecisions() {
        return decisions;
    }
    public void setDecisions(ArrayList<Decision> decisions) {
        this.decisions = decisions;
    }


    public void showMenu() {
        Log.log("", description, LogType.PRODUCTION, LogFormat.NARATOR);
        for (int i = 0; i < decisions.size(); i++) {
            Log.log("", (i+1) + ". " + decisions.get(i).getDescription(), LogType.PRODUCTION, LogFormat.NARATOR);
        }
    }

    public void getDecision() {
        int decisionIndex = 0;
        while (decisionIndex < 1 || decisionIndex > decisions.size()) {
            try {
                decisionIndex = Integer.parseInt(Input.getInput());
                Log.log("", "Decision " + decisionIndex + " selected", LogType.DEBUG, LogFormat.INFO);
            } catch (NumberFormatException e) {
                Log.log("", "Invalid input in Menu("+ this.objectID + ")", LogType.DEBUG, LogFormat.ERROR);
            }
        }
        executeDecision(decisionIndex);
    }

    public void executeDecision(int decisionIndex) {
        if (decisionIndex < 1 || decisionIndex > decisions.size()) {
            Log.log("","Invalid decision in Menu(" + this.objectID +")", LogType.DEBUG, LogFormat.ERROR);
            return;
        }
        decisions.get(decisionIndex-1).execute();
    }
}