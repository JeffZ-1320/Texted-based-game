import java.util.ArrayList;

public class Store extends Village {

    /**
     * Store constructor
     */
    public Store(){
        ArrayList <String> services = new ArrayList<>();
        services.add("Buy and use a health potion");
        services.add("Sell everything in my bag");
        services.add("Exit");
        super.setServices(services);
        super.setType("Store");
    }

    /**
     * Increases the player's health
     * @param p1 the player object
     */
    public void usePotion(Player p1){
        if (p1.getGold() >= 10) {
            p1.setHealth(p1.getHealth() + 10);
            p1.subtractGold(10);
        }else{
            System.out.println("Insufficient gold");
        }
    }

    /**
     * Empty the player's inventory and exchange them for gold
     * @param p1 the player object
     */
    public void sell(Player p1){
        ArrayList <String> itemList = p1.getInventory();
        while (itemList.size() > 0) {
            itemList.remove(0);
            p1.addGold((int)(Math.random() * 11) + 5);
        }
    }
}
