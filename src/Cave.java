/**
 * The cave class is the super class of monster 
 */
public class Cave {
    private int floor;
    private String type;
    private boolean isExit;

    // constructor, getters, setter, and toString until 64
    public Cave(){
        this.floor = 1;
        this.type = "Cave";
        this.isExit = false;
    }

    public Cave(Cave cave) {
        this.floor = cave.getFloor();
        this.type = cave.getType();
        this.isExit = cave.getIsExit();
    }

    // public Cave(int floor, String type, boolean isExit) {
    //     this.floor = floor;
    //     this.type = type;
    //     this.isExit = isExit;
    // }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsExit() {
        return this.isExit;
    }

    public boolean getIsExit() {
        return this.isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }

    @Override
    public String toString() {
        return "{" +
            " floor='" + getFloor() + "'" +
            ", type='" + getType() + "'" +
            ", isExit='" + isIsExit() + "'" +
            "}";
    }

    /**
     * increment the floor number
     */
    public void nextFloor(){
        floor++;
    }

}
