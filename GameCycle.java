import java.util.ArrayList;

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
    private ArrayList<Decision> decisions = new ArrayList<Decision>();
    private boolean isFinished = false;

    // Constructor
    public GameCycle(Character character, Location location) {
        Log.log("", "GameCycle(" + this.objectID + ") created", LogType.DEBUG, LogFormat.INFO);
        this.character = character;
        this.location = location;

        // TRAVEL
        this.decisions.add(new Decision("I want to travel", () -> {
            // Generate travel menu
            ArrayList<Decision> decisions = new ArrayList<Decision>();
            ArrayList<Location> locations = location.getNeighbours();
            for (Location availableLocation : locations) {
                decisions.add(new Decision("Travel to " + availableLocation.getName(), () -> {
                    location.characterExits(character);
                    availableLocation.characterEnters(character);
                    GameCycle gameCycle = new GameCycle(character, availableLocation);
                    return;
                }));
            }
            Menu travelMenu = new Menu(decisions);
            travelMenu.setDescription("Where do you want to travel?>");
            travelMenu.showMenu();
            travelMenu.getDecision();

        }));

        // TRADE
        this.decisions.add(new Decision("I want to trade", () -> {
                // List merchants in the location
                ArrayList<Decision> tradeDecisions = new ArrayList<Decision>();
                ArrayList<Merchant> merchants;

                for (Character locationCharacter : location.getCharactersInLocation()) {
                    if (character instanceof Merchant) {
                        tradeDecisions.add(new Decision("Trade with " + locationCharacter.getName(), () -> {
                            Bargain bargain = new Bargain(character, locationCharacter);
                            GameCycle gameCycle = new GameCycle(character, location);
                        }));

                        this.menu.setDescription("Who do you want to trade with?>");
                        this.menu.showMenu();
                        this.menu.getDecision();
                        GameCycle gameCycle = new GameCycle(character, location);
                    }
                }
            }));

        this.decisions.add(new Decision("I want to continue", () -> {
            Log.log("", "GameCycle(" + this.objectID + ") finished", LogType.DEBUG, LogFormat.INFO);
        }));


        Menu menu = new Menu(decisions);
        menu.setDescription("What do you want to do?>");
        menu.showMenu();
        menu.getDecision();
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
