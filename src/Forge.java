import java.util.ArrayList;

/**
 * Forge is a village building where players can upgrade their weapon and shield as well as recover from battle. 
 */
public class Forge extends Village{
    
    /**
     * Constructor
     */
    public Forge(){
        ArrayList <String> services = new ArrayList<>();
        services.add("Up Grade Weapon");
        services.add("Up Grade Shield");
        services.add("Check Status");
        services.add("Exit");
        super.setServices(services);
        this.setType("Forge");
    }

    /**
     * Increases the player's atk
     * @param p1 the player object
     */
    public void addAtk(Player p1){
        p1.setAtk(p1.getAtk() + 5);
    }

    /**
     * Increases the player's def
     * @param p1 the player object
     */
    public void addDef(Player p1){
        p1.setDef(p1.getDef() + 5);
    }

    /**
     * Up grade the players weapon option and calls the addAtk() method
     * @param p1 the player object
     * @return true if the weapon has been successfully up graded; false otherwise
     */
    public boolean upGradeWeapon(Player p1){
        if (p1.getGold() >= 20) {
            switch (p1.getWeapon()) {
                case "Fist":
                    p1.setWeapon("Wooden Sword");
                    addAtk(p1);
                    p1.setGold(p1.getGold() - 20);
                    return true;
                case "Wooden Sword":
                    p1.setWeapon("Rock Sword");
                    addAtk(p1);
                    p1.setGold(p1.getGold() - 20);
                    return true;
                case "Rock Sword":
                    p1.setWeapon("Iron Sword");
                    addAtk(p1);
                    p1.setGold(p1.getGold() - 20);
                    return true;
                case "Iron Sword":
                    p1.setWeapon("Diamond Sword");
                    addAtk(p1);
                    p1.setGold(p1.getGold() - 20);
                    return true;
                case "Diamond Sword":
                    p1.setWeapon("Enchanted Sword");
                    addAtk(p1);
                    p1.setGold(p1.getGold() - 20);
                    return true;
                case "Enchanted Sword":
                    System.out.println("You have the best sword");
                    return false;
                default:
                    p1.setWeapon("Error Sword");
                    addAtk(p1);
                    return true;
            }
        } else {
            System.out.println("Insufficient Gold");
            return false;
        }
    }

    /**
     * Up grade the players shield option and calls the addDef() method
     * @param p1 the player object
     * @return true if the shield has been successfully up graded; false otherwise
     */
    public boolean upGradeShield(Player p1){
        if (p1.getGold() >= 30) {
            switch (p1.getShield()) {
                case "Empty":
                    p1.setShield("Old Shield");
                    addDef(p1);
                    p1.subtractGold(30);
                    return true;
                case "Old Shield":
                    p1.setShield("Wooden Shield");
                    addDef(p1);
                    p1.subtractGold(30);
                    return true;
                case "Wooden Shield":
                    p1.setShield("Battle Shield");
                    addDef(p1);
                    p1.subtractGold(30);
                    return true;
                case "Battle Shield":
                    p1.setShield("Knight's Shield");
                    addDef(p1);
                    p1.subtractGold(30);
                    return true;
                case "Knight's Shield":
                    p1.setShield("Enchanted Shield");
                    addDef(p1);
                    p1.subtractGold(30);
                    return true;
                case "Enchanted Shield":
                    System.out.println("You have the best shield");
                    return false;
                default:
                    p1.setShield("Error Shield");
                    addDef(p1);
                    return true;
            }
        } else {
            System.out.println("Insufficient gold");
            return false;
        }
    }
}
