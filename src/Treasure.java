import java.util.ArrayList;

public class Treasure extends Monster {
    public Treasure(Cave cave) {
        super(cave, "Treasure", (cave.getFloor() * 5), 0, 0, cave.getFloor() * 2);
        ArrayList<String> drops = new ArrayList<>();
        drops.add("Random good you can sell for money");
        drops.add("Gasoline");
        drops.add("COVID-19");
        drops.add("Broken sword");
        drops.add("Diamond ring");
        drops.add("Pickaxe");
        drops.add("Silk");
        drops.add("Box");
        this.setDrops(drops);

    }

    /**
     * ASCII art of treasure
     */
    public String image(){
        return "__________" + 
                "\n/\\____;;___\\" +
                "\n| /         /" +
                "\n`. ())oo() ." +
                "\n|\\(%()*^^()^\\" +
                "\n| |-%-------|" + 
                "\n\\ | %  ))   |" + 
                "\n\\ |%________|";
    }
}
