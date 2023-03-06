/*
 * Class Bargain represents a transaction between two characters
 * Class is a subclass of GameObject
 * System gives one character an opportunity to sell items to another character for money
 * @author:  JustAKuba
 */

import java.util.ArrayList;

public class Bargain extends GameObject {
    private Character buyer;
    private Character owner;


    private ArrayList<Item> items = new ArrayList<Item>();

    public Bargain(Character buyer, Character owner) {
        Log.log( "",  this.getObjectIdentity() + " created between " + buyer.getObjectIdentity() + " and " + owner.getObjectIdentity(), LogType.DEBUG, LogFormat.INFO);
        owner.say("Hello, I have something to sell");
        buyer.say("Let me have a look...");
        this.buyer = buyer;
        this.owner = owner;
    }

    //GETTERS AND SETTERS//

    public String getObjectIdentity() {
        return "Bargain(" + this.objectID + ")";
    }

    public void setBuyer(Character buyer) {
        this.buyer = buyer;
    }
    public void setOwner(Character owner) {
        this.owner = owner;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Character getBuyer() {
        return buyer;
    }
    public Character getOwner() {
        return owner;
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    //METHODS//
    public void offerItem(Item item) {
         if ( owner.getInventory().contains(item)){
             items.add(item);
         } else {
                Log.log("", "Item " + item.getObjectIdentity() + " is not in inventory of " + owner.getObjectIdentity(), LogType.DEBUG, LogFormat.ERROR);
         }
    }
    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
        } else {
            Log.log("", "Item " + item.getObjectIdentity() + " is not in bargain  " + this.getObjectIdentity(), LogType.DEBUG, LogFormat.ERROR);
        }
        items.remove(item);
    }

    public void evaluateBargain() {
        //Count total value of items
        int totalValue = 0;
        for (Item item : items) {
            totalValue += item.getValue();
        }

        if(totalValue > buyer.getWallet()) {
            owner.say("Are trying to make me laugh? There is no way I would sell it for that price!");
            buyer.say("That's a pity...");
            Log.log("", "Bargain was unsuccessful", LogType.PRODUCTION, LogFormat.NARATOR);
            Log.log("", this.getObjectIdentity() + " failed", LogType.DEBUG, LogFormat.INFO);
        } else {
            owner.say("I accept your offer!");
            buyer.say("Great!");
            Log.log("", "Bargain was successful", LogType.PRODUCTION, LogFormat.NARATOR);
            Log.log("", this.getObjectIdentity() + " succeeded", LogType.DEBUG, LogFormat.INFO);
            for (Item item : items) {
                owner.getInventory().remove(item);
                buyer.getInventory().add(item);
            }
            buyer.setWallet(buyer.getWallet() - totalValue);
            owner.setWallet(owner.getWallet() + totalValue);

        }
    }

    public void debug() {
        Log.debug(this.getObjectIdentity() + " is between " + buyer.getObjectIdentity() + " and " + owner.getObjectIdentity());
        Log.debug("Items in bargain:");
        for (Item item : items) {
            Log.debug(item.getObjectIdentity());
        }
        Log.debug(buyer.getObjectIdentity() + " " + buyer.getInventory() + " " + buyer.getWallet());
        Log.debug(owner.getObjectIdentity() + " " + owner.getInventory() + " " + owner.getWallet());
    }
}