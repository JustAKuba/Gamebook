public abstract class Weapon extends Item {
    private String name;
    private int damageMultiplier;
    private int durability;
    private int maxDurability;
    private int weight;
    private int value;

    public Weapon(String name, int damageMultiplier, int durability, int weight, int value) {
        super(name);
        this.name = name;
        this.damageMultiplier = damageMultiplier;
        this.durability = durability;
        this.maxDurability = durability;
        this.weight = weight;
        this.value = value;
    }

    //GETTERS AND SETTERS//

    public void setName(String name) {
        this.name = name;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
