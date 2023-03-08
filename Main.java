import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Version constant
        final String VERSION = "0.0.1 Alpha";

        // Game start menu
        Log.log("", "------------------", LogType.DEBUG, LogFormat.ERROR);
        Log.log("", "Starting application JacBook version " + VERSION, LogType.DEBUG, LogFormat.ERROR);
        Log.log("", "------------------", LogType.DEBUG, LogFormat.ERROR);
        Log.log("", "* JacBook ver. " + VERSION, LogType.PRODUCTION, LogFormat.NARATOR);
        Log.log("", "* https://github.com/JustAKuba/Gamebook", LogType.PRODUCTION, LogFormat.NARATOR);
        Log.log("", "* When you see this symbol >, game waits for your prompt", LogType.PRODUCTION, LogFormat.NARATOR);
        Log.log("", "------------------", LogType.PRODUCTION, LogFormat.NARATOR);

        //TODO: Resolve if new game or load game when save system is implemented

        // Create player
        Player player = new Player("", 100, 10, 0, 100);

        // START Create menu for naming a character
        ArrayList<Decision> characterNameDecisions = new ArrayList<Decision>();
        characterNameDecisions.add(new Decision("I want to name my character", () -> {
            Log.log("", "What is your character's name? Write it down>", LogType.PRODUCTION, LogFormat.NARATOR);
            player.setName(Input.getInput());
            Log.log("", "Your character's name is " + player.getName(), LogType.PRODUCTION, LogFormat.NARATOR);
        }));
        characterNameDecisions.add(new Decision("I want to use a random name", () -> {
            player.setName(player.generateName());
            Log.log("", "Your character's name is " + player.getName(), LogType.PRODUCTION, LogFormat.NARATOR);
        }));

        Menu characterNameMenu = new Menu(characterNameDecisions);
        characterNameMenu.setDescription("You have to name your character. What do you want to do?>");
        characterNameMenu.showMenu();
        characterNameMenu.getDecision();
        // END Create menu for naming a character

        //TODO: Class selection when implemented

        // Create start location
        Location startLocation = new Location("Reichsburg");
        startLocation.setType(LocationType.TOWN);
        startLocation.setDescription("You are in the town of Reichsburg. You can see a lot of people walking around. You can see a little shop");
        startLocation.characterEnters(player);

        // Initialize game loop
        boolean gameRunning = true;
        GameCycle gameCycle = new GameCycle(player, startLocation);



        //End of program
        Log.log("", "Destroyed application", LogType.DEBUG, LogFormat.ERROR);
        Log.log("", "------------------", LogType.DEBUG, LogFormat.ERROR);
    }
}
