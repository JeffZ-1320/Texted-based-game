import java.util.ArrayList;

public class Zombie extends Monster {
    
    public Zombie(Cave cave) {
        super(cave, "Zombie", (cave.getFloor() + 1) * 3 , (cave.getFloor() + 1) * 2, cave.getFloor(), cave.getFloor());
        ArrayList<String> drops = new ArrayList<>();
        drops.add("Potato");
        drops.add("Moon rock");
        drops.add("[¬º-°]¬");

        this.setDrops(drops);

    }
    
    /**
     * ASCII art of zombie
     */
    public String image(){
        return "\n [º-°]\n  |¬|¬\n  | |\n  」ㄴ";
    }

}
