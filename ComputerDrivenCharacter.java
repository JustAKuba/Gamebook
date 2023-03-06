/*
 * Class ComputerDrivenCharacter is an abstract class for all computer driven characters
 * All computer driven characters have a list of random speech lines
 * All computer driven characters have a method to get random weapon from inventory
 * All computer driven characters have a method to get random speech line

 * @author:  JustAKuba
 */

import java.util.ArrayList;
import java.util.List;

public class ComputerDrivenCharacter extends Character{
    // Variables
    private String name;

    // Speech lines list
    private List<String> randomSpeechLines = new ArrayList<String>();



    public ComputerDrivenCharacter(String name, int health, int strength, int defense, int wallet) {
        super(name, health, strength, defense , wallet);

    }

    //GETTERS AND SETTERS//

    // Get speech lines
    public List<String> getRandomSpeechLines() {
        return randomSpeechLines;
    }
    // Set speech lines
    public void setRandomSpeechLines(List<String> randomSpeechLines) {
        this.randomSpeechLines = randomSpeechLines;
    }


    //METHODS//
    // Get random weapon from inventory (inventory has also non-weapon items), character has inventory
    public Weapon getRandomWeapon() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        for (Item item : this.getInventory()) {
            if (item instanceof Weapon) {
                weapons.add( (Weapon) item);
            }
        }
        if (weapons.size() > 0) {
            return weapons.get((int) (Math.random() * weapons.size()));
        } else {
            return null;
        }
    }
    // Get random speech line
    public String getRandomSpeechLine() {
        if (randomSpeechLines.size() > 0) {
            return randomSpeechLines.get((int) (Math.random() * randomSpeechLines.size()));
        } else {
            Log.log("", "No speech lines for " + this.getName() + ", but speech requested", LogType.DEBUG, LogFormat.WARNING);
            return null;
        }
    }
    // Add speech line
    public void addSpeechLine(String speechLine) {
        randomSpeechLines.add(speechLine);
    }


}

