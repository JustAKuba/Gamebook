/*
 * Class Represents a type of weapon that can be used in melee combat
 * Class is a subclass of Weapon
 * Class is subclass of Item
 * @author:  JustAKuba
 */

public class MeleeWeapon extends Weapon{
    private String name;
    private int damageMultiplier;
    private int durability;
    private int maxDurability;
    private int weight;

    public MeleeWeapon(String name,int value) {
        super(value);
    }



}
