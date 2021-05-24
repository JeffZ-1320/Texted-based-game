public class JeffZhuoM16Main {
    public static void main(String[] args) throws Exception {
        Player p1 = new Player();
        Cave cave = new Cave();

        Controller.gameName();
        Controller.intro();
        Controller.tutorial(p1);
        // repeat until player is no longer alive
        do{
            Controller.enterVillage(p1);
            if(p1.isLive()){
                Controller.enterCave(p1, cave);
            }
            
        }while(p1.isLive());
        Controller.endGame(p1);
    }
}
