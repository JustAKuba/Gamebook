import java.util.ArrayList;
import java.util.List;

public class ComputerDrivenCharacter extends Character{
    public ComputerDrivenCharacter(String name, int health, int strength, int defense, double attackRating) {
        super(name, health, strength, defense);
    }

    //Get random weapon from inventory (inventory has also non-weapon items), character has inventory
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


}

