import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 * comments on all
 */

public class Controller {
    /**
     * Displays the name of the game when the program initially run. 
     * @throws InterruptedException
     */
    public static void gameName() throws InterruptedException{
        System.out.println(",--.   ,--.  ,--.    ,--.  ,--.           ,------. ,------.  ,----." + 
        "\n|  |   `--',-'  '-.,-'  '-.|  | ,---.     |  .--. '|  .--. ''  .-./  "  +
        "\n|  |   ,--.'-.  .-''-.  .-'|  || .-. :    |  '--'.'|  '--' ||  | .---. " + 
        "\n|  '--.|  |  |  |    |  |  |  |\\   --.    |  |\\  \\ |  | --' '  '--'  | " + 
        "\n`-----'`--'  `--'    `--'  `--' `----'    `--' '--'`--'      `------'\n\n"
        );
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Introducing the plot line
     * @throws InterruptedException
     */
    public static void intro() throws InterruptedException{
        System.out.println("A long long time ago in a land far far away...");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("There is a magical cave that hides great treasures.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Adventurers from all over the world came trying to find the greatest treasure, only a few came out. ");
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("Will you be the lucky one to discover the hidden treasures?");
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    /**
     * A walk through of basic concepts of the game
     * @param p1
     * @throws InterruptedException
     */
    public static void tutorial(Player p1) throws InterruptedException{
        System.out.println("\n|-------------------------------------------------------------------|");
        System.out.println("TUTORIAL\n");
        TimeUnit.SECONDS.sleep(1);
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("To navigate through the game, you will be prompted with number(s) to pick from.");
            System.out.println("[1] To continue");
            System.out.print("Your input: ");
        }while(scan.nextInt() != 1);
        scan.nextLine();
        // do{
        //     System.out.println("To check your character status you can type \"/status\"");
        //     System.out.print("Your input (type \"/status\"): ");
        // }while(!scan.nextLine().equals("/status"));
        TimeUnit.SECONDS.sleep(1);
        // System.out.println("|-------------------------------------------------------------------|");
        // System.out.println(p1.toString());
        System.out.println("Later in the game you can check your status in the FORGE and after every battle with a monster");
        TimeUnit.SECONDS.sleep(2);
        do{
            System.out.println("HINT: When you want to manually end the game you can type “/end” (does not work here)");
            System.out.println("[1] To continue");
            System.out.print("Your input: ");
        }while(scan.nextInt() != 1);
        System.out.println("You have finished the tutorial");
        TimeUnit.SECONDS.sleep(1);
        

    }

    /**
     * Player entering the village
     * @throws InterruptedException
     */
    public static void enterVillage(Player p1) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        Village village = new Village();
        System.out.println("You are now in the Village");
        String options = "";
        for(int i = 0; i < village.getServices().size(); i++){
            options += String.format("[%d] %s ", i + 1, village.getServices().get(i));
        }
        String choice = "";
        do{
            System.out.println("Where would you like to go?");
            System.out.println(options);
            Scanner scan = new Scanner(System.in);
            System.out.print("You: ");
            choice = scan.nextLine();
        }while(!choice.equals("/end") && (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) > village.getServices().size()));
        

        switch (choice) {
            case "1":
                enterForge(p1);
                break;
            case "2":
                enterStore(p1);
                break;
            // case "3":
            //     enterHotel(p1);
            //     break;
            case "3":
                break;
            case "/end":
                p1.setHealth(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * Player entering the
     * @throws InterruptedException
     */
    public static void enterForge(Player p1) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        Forge forge = new Forge();
        System.out.println("You are now at the Forge");
        String options = "";
        for(int i = 0; i < forge.getServices().size(); i++){
            options += String.format("[%d] %s ", i + 1, forge.getServices().get(i));
        }
        String choice = "";
        do{
            System.out.println("What would you like to do?");
            System.out.println(options);
            Scanner scan = new Scanner(System.in);
            System.out.print("You: ");
            choice = scan.nextLine();
        }while(!choice.equals("/end") && (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) > forge.getServices().size()));
        
        switch (choice) {
            case "1":
                if (forge.upGradeWeapon(p1)) {
                    System.out.println("Weapon upgraded");
                }
                TimeUnit.MILLISECONDS.sleep(500);
                enterForge(p1);
                break;
            case "2":
                if (forge.upGradeShield(p1)) {
                    System.out.println("Shield upgraded");
                }
                TimeUnit.MILLISECONDS.sleep(500);
                enterForge(p1);
                break;
            case "3":
                System.out.println("|-------------------------------------------------------------------|");
                System.out.println(p1.toString());
                enterForge(p1);
                break;
            case "4":
                enterVillage(p1);
                break;
            case "/end":
                p1.setHealth(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    
    /**
     * Player enters the store
     */
    public static void enterStore(Player p1) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        Store store = new Store();
        System.out.println("You are at the village store");
        String options = "";
        for(int i = 0; i < store.getServices().size(); i++){
            options += String.format("[%d] %s ", i + 1, store.getServices().get(i));
        }
        String choice = "";
        do{
            System.out.println("What would you like to do?");
            System.out.println(options);
            Scanner scan = new Scanner(System.in);
            System.out.print("You: ");
            choice = scan.nextLine();
        }while(!choice.equals("/end") && (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) > store.getServices().size()));
        switch (choice) {
            case "1":
                store.usePotion(p1);
                System.out.println("Your health is now " + p1.getHealth());
                TimeUnit.SECONDS.sleep(1);
                enterStore(p1);;
                break;
            case "2":
                store.sell(p1);
                System.out.println("You have sold everything in your inventory and you currently have " + p1.getGold() + " gold.");
                TimeUnit.SECONDS.sleep(1);
                enterStore(p1);
                break;
            case "3":
                enterVillage(p1);
                break;
            case "/end":
                p1.setHealth(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    // /**
    //  * Player enters the hotel
    //  * @param p1
    //  */
    // public static void enterHotel(Player p1){
    //     System.out.println("|-------------------------------------------------------------------|");
        
    // }

    //------------------------------------------------------- End of Village code -------------------------------------------------------------//

    /**
     * Player enters the cave
     * @param p1 
     * @throws InterruptedException pause display error
     */
    public static void enterCave(Player p1, Cave cave) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("You have entered the cave: floor " + cave.getFloor());
        String choice = "";
        do{
            System.out.println("[1] Continue");
            System.out.print("You: ");
            choice = scan.nextLine();
            if (choice.equals("/end")) {
                choice = "1";
                p1.setHealth(0);
            }
        }while(!choice.equals("1"));

        for (int i = 0; i < cave.getFloor(); i++) {
            // add a if player isLive here
            if (p1.isLive()) {
                switch ((int)(Math.random() * 4) + 1) {
                    case 1:
                        encounterSpider(p1, cave);
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println(p1.toString());
                        break;
                    case 2:
                        encounterZombie(p1, cave);
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println(p1.toString());
                        break;
                    case 3:
                        encounterVampire(p1, cave);
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println(p1.toString());
                        break;
                    case 4:
                        encounterTreasure(p1, cave);
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println(p1.toString());
                        break;
                        
                    default:
                        System.out.println("|-------------------------------------------------------------------|");
                        System.out.println("Monster \"random\" error");
                        System.out.println(p1.toString());
                        break;
                }
            }
        }
        boolean repeat = true;
        do{
            if (p1.isLive()) {
                System.out.println("|-------------------------------------------------------------------|");
                System.out.println("You have discovered an exit!");
                System.out.println("Would you like to exit the cave?");
                System.out.println("[1] Yes [2] No");
                System.out.print("You: ");
                choice = scan.nextLine();
                if (choice.equals("2")) {
                    cave.nextFloor();
                    enterCave(p1, cave);
                    repeat = false;
                }else if(choice.equals("1")){
                    repeat = false;
                }
            }else{
                repeat = false;
            }
        }while(repeat);
        
    }

    /**
     * Carry the player through the battle process/scene
     * @param p1 player
     * @param mon monster the player will be battling with
     * @throws InterruptedException  pause display error
     */
    public static void battleMonster(Player p1, Monster mon) throws InterruptedException{
        String choice = "";
        do{
            System.out.println("What would you do?");
            System.out.println("[1] Fight [2] Escape");
            Scanner scan = new Scanner(System.in);
            System.out.print("You:");
            choice = scan.nextLine();
            if (choice.equals("/end")) {
                p1.setHealth(0);
            } else if (Integer.parseInt(choice) == 1) {
                while (mon.checkIsLive() && p1.isLive()){
                    if(p1.isLive()){
                        mon.injure(p1.getAtk());
                        System.out.println("You attacked the " + mon.getMonsterName());
                        TimeUnit.MILLISECONDS.sleep(1000);
                        if (mon.getHp() > 0) {
                            System.out.println(mon.getMonsterName() + "'s HP: " + mon.getHp());
                        }
                        TimeUnit.MILLISECONDS.sleep(1500);
                    }
                    if(mon.checkIsLive()){
                        p1.injure(mon.getAtk());
                        System.out.println("The "+ mon.getMonsterName() + " attacked you");
                        if (p1.getHealth() > 0) {
                            TimeUnit.MILLISECONDS.sleep(1000);
                            System.out.println("Your HP: " + p1.getHealth());
                        }
                        TimeUnit.MILLISECONDS.sleep(1500);
                    }
                }
                if(!p1.isLive()){
                    System.out.println("\nYou got defeated");
                    TimeUnit.MILLISECONDS.sleep(500);
                    
                }else {
                    System.out.println("\nYou have defeated the " + mon.getMonsterName() + "!");
                    p1.addPoints(mon.getPoints());
                    TimeUnit.SECONDS.sleep(1);
                    String dropItem = mon.drop();
                    p1.addToInventory(dropItem);
                    System.out.println("You have obtained a " + dropItem);
                } 
            }else if (Integer.parseInt(choice) == 2) {
                System.out.println("The " + mon.getMonsterName() + " attacked you");
                p1.injure(mon.getAtk());
                if (p1.isLive()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("Your health is now " + p1.getHealth());
                    TimeUnit.MILLISECONDS.sleep(700);
                    System.out.println("You have escaped the " + mon.getMonsterName());
                }
            }
        }while (!(choice.equals("1") || choice.equals("2") || choice.equals("/end")));
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * The player encounters the spider monster
     * @param p1 the player
     * @param cave the cave used to create the spider monster
     * @throws InterruptedException pause display error
     */
    public static void encounterSpider(Player p1, Cave cave) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("You have encountered a cave spider");
        Spider spider = new Spider(cave);
        System.out.println(spider.image());
        
        battleMonster(p1, spider);
        
    }

    /**
     * The player encounters the zombie monster
     * @param p1 the player
     * @param cave the cave used to create the zombie monster
     * @throws InterruptedException pause display error
     */
    public static void encounterZombie(Player p1, Cave cave) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("You have encountered a zombie");
        Zombie zombie = new Zombie(cave);
        System.out.println(zombie.image());
        
        battleMonster(p1, zombie);
    }

    /**
     * The player encounters the vampire monster
     * @param p1 the player
     * @param cave the cave used to create the vampire monster
     * @throws InterruptedException pause display error
     */
    public static void encounterVampire(Player p1, Cave cave) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("You have encountered a vampire");
        Vampire vampire = new Vampire(cave);
        System.out.println(vampire.image());
        
        battleMonster(p1, vampire);
    }

    /**
     * The player encounters a treasure
     * @param p1 the player
     * @param cave the cave used to create the treasure
     * @throws InterruptedException pause display error
     */
    public static void encounterTreasure(Player p1, Cave cave) throws InterruptedException{
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("You have encountered a treasure!");
        Treasure treasure = new Treasure(cave);
        System.out.println(treasure.image());
        
        battleMonster(p1, treasure);
    }

    /**
     * When the player dies or when the player wants to exit the game, this method will be 
     * triggered. And it will give the score the player has earned so far in the game. 
     * @param p1 the player
     */
    public static void endGame(Player p1){
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("Game over");
        System.out.println("+-------------------------+");
        System.out.println("|                         |");
        System.out.println("|     Best score: " + p1.getPoint() + "       |");
        System.out.println("|                         |");
        System.out.println("+-------------------------+");
    }
}
