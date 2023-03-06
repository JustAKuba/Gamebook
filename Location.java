import java.util.ArrayList;

public class Location extends GameObject{

    // Variables
    String name;
    LocationType type;
    ArrayList<Character> charactersInLocation = new ArrayList<Character>();

    // Constructor
    public Location(String name, LocationType type) {
        this.name = name;
        this.type = type;

        switch (type) {
            case FOREST:
                // Do something
                break;
            case MOUNTAIN:
                // Do something
                break;
            case DESERT:
                // Do something
                break;
            case TOWN:
                // Spawn merchant with random items and random prices that are somewhat relevant to the damage and durability of the weapon
                // The merchant will have a random amount of money (max 400), and will have a random amount of items
                // The merchant will be weaponsmith, so he will have weapons

                // Add merchant to location
                this.characterEnters(new Merchant("", 100, 10, 10, 100));
                // Add random items to merchant's inventory with random stats, but not too high
                for(int i = 0; i < Math.random(); i++) {
                    charactersInLocation.get(0).addItem(new MeleeWeapon(false,"", 0,0,0,0) {
                    });
                }
                break;
            case CASTLE:
                // Do something
                break;
            case CAVE:
                // Do something
                break;
            case DUNGEON:
                // Do something
                break;
        }
    }

    //Getter
    public String getObjectIdentity() {
        return name + "(" + objectID + ")";
    }
    public String getName() {
        return name;
    }

    // Methods
    // Add character to location
    public void characterEnters(Character character) {
        charactersInLocation.add(character);
        Log.log("", character.getName() + " enters the " + this.name, LogType.PRODUCTION, LogFormat.NARATOR);
        Log.log("", character.getObjectIdentity() + " entered the " + this.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }
    // Remove character from location
    public void characterExits(Character character) {
        charactersInLocation.remove(character);
        Log.log("", character.getName() + " leaves the " + this.name, LogType.PRODUCTION, LogFormat.NARATOR);
        Log.log("", character.getObjectIdentity() + " left the " + this.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }

}
