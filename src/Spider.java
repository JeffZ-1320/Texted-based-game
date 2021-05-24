import java.util.ArrayList;

public class Spider extends Monster{

    public Spider(Cave cave) {
        super(cave, "Spider", (cave.getFloor() + 1) * 3 , (cave.getFloor() + 1) * 2, cave.getFloor(), cave.getFloor());
        ArrayList<String> drops = new ArrayList<>();
        drops.add("Spider web");
        drops.add("Baby spider");
        drops.add("spider poison");
        drops.add("Spider fossil");
        this.setDrops(drops);

    }
    
    /**
     * ASCII art of spider
     */
    public String image(){

        return("  / _ \\" +
                            "\n\\_\\(_)/_/" +
                            "\n _//o\\\\_" +
                            "\n  /   \\"
        
                            );
    }
}
