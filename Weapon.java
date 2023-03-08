public abstract class Weapon extends Item {
    private String name;
    private int damageMultiplier;
    private int durability;
    private int maxDurability;
    private int weight;
    private int range;
    private boolean custom;


    public Weapon(int value) {
        super(value);
        this.custom = false;
        this.setName(this.generateName());
        this.damageMultiplier = (int) (Math.random() * 10) + 1;
        this.durability = (int) (Math.random() * 100) + 1;
        this.maxDurability = this.durability;
        this.weight = (int) (Math.random() * 10) + 1;
        this.setValue((int) (Math.random() * 100) + 1);
    }

    //GETTERS AND SETTERS//
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

    // Methods
    // Generate random weapon name
    public String generateName() {
        String[] meleeWeaponFirstParts = {"Blood", "Doom", "Void", "Storm", "Shadow", "Fire", "Thunder", "Ice", "Soul", "Death", "Holy", "Blade", "Sword", "Demon", "Dragon", "Witch", "War", "Iron", "Chaos", "Light"};
        String[] meleeWeaponSecondParts = {"fang", "strike", "thorn", "edge", "breaker", "slayer", "cleaver", "rend", "shatter", "reaper", "crusher", "piercer", "maul", "pummel", "razor", "blade", "crimson", "eternity", "executioner", "warrior"};

        String name = meleeWeaponFirstParts[(int) (Math.random() * meleeWeaponFirstParts.length)];
        String surname = meleeWeaponSecondParts[(int) (Math.random() * meleeWeaponSecondParts.length)];

        return name + " " + surname;
    }

}
