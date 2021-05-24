import java.util.ArrayList;

public class Player{
    private int health;
    private int gold;
    private int point;
    private int atk;
    private int def;
    private String weapon;
    private String shield;
    private ArrayList<String> inventory;
    // private Cave cave;

    // constructor, getter, setters, and toString
    public Player() {
        this.health = 10;
        this.gold = 10;
        this.point = 0;
        this.atk = 5;
        this.def = 0;
        this.weapon = "Fist";
        this.shield = "Empty";
        this.inventory = new ArrayList<String>();
        // this.cave = new Cave();
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getShield() {
        return this.shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public ArrayList<String> getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public String toString(){
        String status = "Player: " +
                        "\nHP: " + health + 
                        "\nGold: " + gold + 
                        "\nPoints: " + point +
                        "\nATK: " + atk + 
                        "\nDEF: " + def + 
                        "\nWeapon: " + weapon + 
                        "\nShield: " + shield + 
                        "\nInventory: " + "<";
        for (String item : inventory) {
            status += item + ", ";
        }
        if (inventory.size() > 0) {
            status += "\b\b>";
        } else {
            status += ">";
        }
        return status;
    }

    /**
     * Subtract num from gold in the player object
     * @param num number of gold to be subtracted
     */
    public void subtractGold(int num){
        gold -= num;
    }

    /**
     * Add num into gold in the player object
     * @param num number of gold to be added
     */
    public void addGold(int num){
        gold += num;
    }

    /**
     * The player takes damage from the monster
     * @param damage 
     */
    public void injure(int damage){
        if (getDef() < damage) {
            setHealth(getHealth() - (damage - getDef()));
        }
    }

    /**
     * return true if the player's health is greater than 0
     * @return 
     */
    public boolean isLive(){
        return getHealth() > 0;
    }

    /**
     * Add a drop item from monster to the player's inventory
     * @param item
     */
    public void addToInventory(String item){
        inventory.add(item);
    }

    /**
     * Points shows the overall performance of the player throughout the game
     * @param num points to be added
     */
    public void addPoints(int num){
        point += num;
    }
}