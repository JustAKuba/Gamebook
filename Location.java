import java.util.ArrayList;

public class Location extends GameObject{

    // Variables
    String name;
    LocationType type;
    String description;
    ArrayList<Character> charactersInLocation = new ArrayList<Character>();
    ArrayList<Location> neighbours = new ArrayList<Location>();

    // Constructor
    public Location(String name) {
        this.name = name;
        this.type = LocationType.values()[(int) (Math.random() * LocationType.values().length)];
        this.description = "This is a " + type.toString().toLowerCase() + " named" + this.name + ".";

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
                Merchant merchant = new Merchant("", 100, 10, 10, 100);
                this.characterEnters(merchant);
                // Add random items to merchant's inventory with random stats, but not too high
                for(int i = 0; i < Math.random(); i++) {
                    MeleeWeapon newWeapon = new MeleeWeapon("", 0);
                    merchant.addItem(newWeapon);
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

    // Getter
    public String getObjectIdentity() {
        return name + "(" + objectID + ")";
    }
    public String getName() {
        return name;
    }
    public ArrayList<Location> getNeighbours() {
        return neighbours;
    }
    public ArrayList<Character> getCharactersInLocation() {
        return charactersInLocation;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setType(LocationType type) {
        this.type = type;
    }

    // Methods
    // Generate random names
    public String generateName() {
        String[] fantasyAdjectives = {"Astral", "Bewitched", "Chimerical", "Divine", "Ethereal", "Fabled", "Glimmering", "Hallowed",
                "Illusory", "Jagged", "Kaleidoscopic", "Luminous", "Mystical", "Nebulous", "Otherworldly", "Prismatic", "Radiant", "Seraphic",
                "Transcendent", "Untamed", "Vibrant", "Whimsical", "Xenial", "Yonder", "Zany", "Arcane", "Breathtaking", "Celestial",
                "Dreamy", "Enchanted", "Fanciful", "Gossamer", "Heavenly", "Infinite", "Jovial", "Kingly", "Lively", "Magical", "Nostalgic",
                "Omnipotent", "Pristine", "Quaint", "Regal", "Surreal", "Timeless", "Unearthly", "Vast", "Wondrous", "Xanthic", "Yielding",
                "Zestful"};
        // Generate noun based on location type
        String noun = "";
        switch (type) {
            case FOREST:
                noun = "Forest";
                break;
            case MOUNTAIN:
                noun = "Mountain";
                break;
            case DESERT:
                noun = "Desert";
                break;
            case TOWN:
                noun = "Town";
                break;
            case CASTLE:
                noun = "Castle";
                break;
            case CAVE:
                noun = "Cave";
                break;
            case DUNGEON:
                noun = "Dungeon";
                break;
        }
        // Generate adjective
        String adjective = fantasyAdjectives[(int) (Math.random() * fantasyAdjectives.length)];
        // Generate name
        String name = adjective + " " + noun;
        return name;
    }


    // Add character to location
    public void characterEnters(Character character) {
        charactersInLocation.add(character);
        if (character instanceof Player) {
            Log.log("", character.getName() + " enters the " + this.name, LogType.PRODUCTION, LogFormat.NARATOR);
            Log.log("", this.description, LogType.PRODUCTION, LogFormat.NARATOR);
        }
        Log.log("", character.getObjectIdentity() + " entered the " + this.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
        // If character is player, generate neighbours, max 4, min 1, add them to location neighbours
        if(character instanceof Player) {
            // Generate random amount of neighbours
            int amountOfNeighbours = (int) (Math.random() * 4) + 1;
            // Generate neighbours
            for(int i = 0; i < amountOfNeighbours; i++) {
                Location newLocation = generateLocation();
                this.addNeighbour(newLocation);
            }
        }

    }
    // Remove character from location
    public void characterExits(Character character) {
        charactersInLocation.remove(character);
        if (character instanceof Player) {
            Log.log("", character.getName() + " leaves the " + this.name, LogType.PRODUCTION, LogFormat.NARATOR);
        }
        Log.log("", character.getObjectIdentity() + " left the " + this.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }
    // Add neighbour to location
    public void addNeighbour(Location location) {
        neighbours.add(location);
        Log.log("", this.getObjectIdentity() + " added neighbour " + location.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }
    // Remove neighbour from location
    public void removeNeighbour(Location location) {
        neighbours.remove(location);
        Log.log("", this.getObjectIdentity() + " removed neighbour " + location.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }
    // Generate location
    public Location generateLocation() {
        // Select random type
        LocationType type = LocationType.values()[(int) (Math.random() * LocationType.values().length)];
        // Select random name
        String name = generateName();
        // Create location
        Location location = new Location(name);
        return location;
    }

}
