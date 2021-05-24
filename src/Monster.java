import java.util.ArrayList;

public class Monster extends Cave{
    private String monsterName;
    private int hp;
    private int atk;
    private int def;
    private int points;
    private boolean isLive;
    private ArrayList<String> drops;
    

    // constructors, getters, setters
    public Monster(Cave cave, String monsterName, int hp, int atk, int def, int points) {
        super(cave);
        this.monsterName = monsterName;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.points = points;
        this.isLive = true;
    }

    public String getMonsterName() {
        return this.monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public boolean isIsLive() {
        return this.isLive;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<String> getDrops() {
        return this.drops;
    }

    public void setDrops(ArrayList<String> drops) {
        this.drops = drops;
    }

    /**
     * Check whether the player is still alive
     * @return boolean of isLive
     */
    public boolean checkIsLive(){
        if (hp > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * When the monster takes damage
     * @param atk the amount of damage the monster takes
     * @return
     */
    public void injure(int atk){
        if (this.getDef() < atk) {
            this.setHp(this.getHp() - (atk - this.getDef()));
        }
        
    }

    /**
     * Randomly return the item the monster will drop when defeated
     * @return a drop item
     */
    public String drop(){
        return drops.get((int)(Math.random() * drops.size()));
    }

    /**
     * ASCII art of the monster
     */
    public String image(){
        return "";
    }
}
