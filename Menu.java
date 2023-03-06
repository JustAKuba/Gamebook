/*
    * This class represents a menu that can be displayed to the user.
    * It contains a list of decisions that can be made by the user.
    * @author: JustAKuba
 */
public class Menu {
    private Decision[] decisions;

    public Menu(Decision[] decisions) {
        this.decisions = decisions;
        Log.log("", "Menu created", LogType.PRODUCTION, LogFormat.NARATOR);
    }

    public void showMenu() {
        Log.log("", "What do you want to do?", LogType.PRODUCTION, LogFormat.NARATOR);
        for (int i = 0; i < decisions.length; i++) {
            Log.log("", (i+1) + ". " + decisions[i].getDescription(), LogType.PRODUCTION, LogFormat.NARATOR);
        }
    }

    public void executeDecision(int decisionIndex) {
        if (decisionIndex < 1 || decisionIndex > decisions.length) {
            System.out.println("Invalid decision selected");
            return;
        }
        decisions[decisionIndex-1].execute();
    }
}