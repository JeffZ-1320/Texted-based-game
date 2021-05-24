import java.util.ArrayList;

public class Vampire extends Monster {
    
    public Vampire(Cave cave) {
        super(cave, "Vampire", (cave.getFloor() + 1) * 3 , (cave.getFloor() + 1) * 2, cave.getFloor(), cave.getFloor());
        ArrayList<String> drops = new ArrayList<>();
        drops.add("Vampire's teeth");
        drops.add("Bat fossil");
        drops.add("Vampire blood");

        this.setDrops(drops);

    }
    
    /**
     * ASCII of vampire
     */
    public String image(){
        return "\n(㇏(•̀ᵥᵥ•́)ノ)\n";
    }
}
