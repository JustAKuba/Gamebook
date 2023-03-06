import java.util.ArrayList;
import java.util.List;

//Create abstract class Character
public abstract class Character extends GameObject {
    private String name;
    private int health;
    private int strength;
    private int defense;
    private String description;
    private int wallet;

    private List<Item> inventory = new ArrayList<Item>();

    //Create constructor
    public Character(String name, int health, int strength, int defense, int wallet) {
        //Set variables
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.wallet = wallet;

        //Log
        Log.log("", this.getClass() + " named: " + getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }

    //GETTERS AND SETTERS//

    public String getObjectIdentity() {
        return name + "(" + objectID + ")";
    }

    //Create abstract method TODO: Implement when i know
    public String about() {
        return description;
    }

    //Create method to get wallet
    public int getWallet() {
        return wallet;
    }
    //Create method to get defense
    public int getDefense() {
        return defense;
    }

    //Create method to get name
    public String getName() {
        return name;
    }
    //Create method to get health
    public int getHealth() {
        return health;
    }
    //Create method to get strength
    public int getStrength() {
        return strength;
    }
    //Create method to set name
    public void setName(String n) {
        name = n;
        Log.log("", name + " set name to " + n, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set health
    public void setHealth(int h) {
        health = h;
        Log.log("", name + " set health to " + h, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set strength
    public void setStrength(int s) {
        strength = s;
        Log.log("", name + " set strength to " + s, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set defense
    public void setDefense(int d) {
        defense = d;
        Log.log("", name + " set defense to " + d, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set description
    public void setDescription(String d) {
        description = d;
        Log.log("", name + " set description to " + d, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to get inventory
    public List<Item> getInventory() {
        return inventory;
    }
    //Create method to set inventory
    public void setInventory(List<Item> i) {
        inventory = i;
        Log.log("", name + " set inventory to " + i, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to set wallet
    public void setWallet(int w) {
        wallet = w;
        Log.log("", getObjectIdentity() + " set wallet to " + w, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to get wallet
    public void getWallet(int w) {
        wallet = w;
        Log.log("", getObjectIdentity() + " set wallet to " + w, LogType.DEBUG, LogFormat.INFO);
    }
    //Create method to return string
    public String toString() {
        return name + " " + health + " " + strength + " " + defense + " " + description + " " + inventory;
    }

    //OTHER METHODS//

    //Create method to check if character is alive
    public boolean isAlive() {
        return health > 0;
    }

    //Create method to lower health
    public void lowerHP(int damage) {
        health -= damage;
        Log.log("", getObjectIdentity() + " took " + damage + " damage, remaining HP:" + health + ", defense:" + defense, LogType.DEBUG, LogFormat.INFO);
    }

    //Create method to add item to inventory
    public void addItem(Item item) {

        inventory.add(item);
        Log.log("", getObjectIdentity() + " added item " + item.getObjectIdentity() + " to his inventory", LogType.DEBUG, LogFormat.INFO);
    }

    //Create method to add money to wallet
    public void addWallet(int amount) {
        wallet += amount;
        Log.log("", getObjectIdentity() + " added " + amount + " to his wallet, new wallet: " + wallet, LogType.DEBUG, LogFormat.INFO);
    }

    //Create method to remove money from wallet
    public void removeWallet(int amount) {
        wallet -= amount;
        Log.log("", getObjectIdentity() + " removed " + amount + " from his wallet, new wallet: " + wallet, LogType.DEBUG, LogFormat.INFO);
    }

    //Create method to remove item from inventory
    public void removeItem(Item item) {
        inventory.remove(item);
        Log.log("", getObjectIdentity()+ " removed item " + item.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
    }

    //Create method to say text
    public void say(String text) {
        Log.log( name, text, LogType.PRODUCTION, LogFormat.SPEECH);
        Log.log("", getObjectIdentity() + " said \"" + text + "\"", LogType.DEBUG, LogFormat.INFO);
    }

    public void giveDamage(Character defender) {
        //If this character is a ComputerDrivenCharacter, get random weapon from inventory, else get equipped weapon
        Weapon weapon;
        if (this instanceof ComputerDrivenCharacter) {
            weapon = ((ComputerDrivenCharacter) this).getRandomWeapon();
        } else {
            weapon = ((Player) this).getEquippedWeapon();
        }

        double multiplier;
        String weaponName;
        if (weapon == null) {
            multiplier = 1;
            weaponName = "fists";
        } else {
            multiplier = weapon.getDamageMultiplier();
            weaponName = weapon.getName();
        }

        double damage = strength * multiplier - defender.getDefense();
        defender.lowerHP((int) damage);
        Log.log("", name + " dealt " + damage + " damage to " + defender.getName() + ", base damage: " + strength + ", multiplier: " + multiplier + " with weapon " + weaponName, LogType.DEBUG, LogFormat.INFO);

        //TODO: Implement when weapons done
    }
    //Create method to get damage

    //Create method to attack TODO: Implement when weapons done

}
