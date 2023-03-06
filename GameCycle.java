/*
    * Each GameCycle is a section of the game, when player makes an interaction with character or fights a battle, then
    * has a chance to enter commands to interact with the game, then he can use command continue to open next decision menu,
    * after new selection a new cycle begins.
 */
public class GameCycle extends GameObject{
    // Variables
    private Character character;
    private Location location;
    private Menu menu;
    private Decision[] decisions;
    private boolean isFinished = false;

    // Constructor
    public GameCycle(Character character, Location location) {
        this.character = character;
        this.location = location;
        this.decisions = new Decision[3];
        this.decisions[0] = new Decision("Talk to character", () -> {
            // Do something
        });
        this.decisions[1] = new Decision("Fight character", () -> {
            // Do something
        });
        this.decisions[2] = new Decision("Continue", () -> {
            // Do something
        });
        this.menu = new Menu(decisions);
    }

    // Methods
    public void start() {
        // Do something
    }

    public void end() {
        // Do something
    }

    public void showMenu() {
        menu.showMenu();
    }

    public void executeDecision(int decisionIndex) {
        menu.executeDecision(decisionIndex);
    }

    public boolean isFinished() {
        return isFinished;
    }

}
