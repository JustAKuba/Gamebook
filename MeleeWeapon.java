/*
 * Class Represents a type of weapon that can be used in melee combat
 * Class is a subclass of Weapon
 * Class is subclass of Item
 * @author:  JustAKuba
 */

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(boolean custom,String name, int damageMultiplier, int durability, int weight, int value) {
        super(name, damageMultiplier, durability, weight, value);
    }

}
