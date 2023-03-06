public class Main {
    public static void main(String[] args) {

        Player player = new Player("Jack", 100, 40, 50, 0);

        Weapon weapon1 = new MeleeWeapon(false,"Sword", 10, 100, 10, 100);

        player.addItem(weapon1);

        Location location = new Location("Reichburg", LocationType.TOWN);

        location.characterEnters(player);


        //End of program
        Log.log("", "Destroyed application", LogType.DEBUG, LogFormat.ERROR);
        Log.log("", "------------------", LogType.DEBUG, LogFormat.ERROR);
    }
}
