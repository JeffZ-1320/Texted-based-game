import java.util.ArrayList;
/**
 * Village is the super class of all village buildings
 * 
 */
public class Village {
    private String type;
    private ArrayList<String> services;

    // constructor, getters, and setters
    public Village() {
        this.type = "Village";
        services = new ArrayList<>();
        services.add("Forge");
        services.add("Store");
        services.add("Cave");
    }

    public Village(ArrayList<String> services){
        this.services = services;
    }


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ArrayList<String> getServices() {
        return this.services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }




}
