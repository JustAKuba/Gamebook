public class Player extends Character{

    private Weapon equippedWeapon;

    public Player(String name, int health, int strength, int defense, int wallet) {
        super(name, health, strength, defense, wallet);
    }

    //GETTERS AND SETTERS//

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
}
