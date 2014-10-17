
import java.util.ArrayList;

public class Game{

    public ArrayList <Unit> playerArmy, npc1Army;
    
    
    public Game(){
        this.createBoard();
        this.playerArmy = new ArrayList<>();
        this.npc1Army = new ArrayList<>();
        
    }
    
    public void addPlayerMusketeer(){
        Unit u = new Musketeer();
        playerArmy.add(u);
        
        
    }
    public void addPlayerCavalry(){
        Unit u = new Cavalry();
        playerArmy.add(u);
        
        
    }
    public void addPlayerPikeman(){
        Unit u = new Pikeman();
        playerArmy.add(u);
        
        
    }

    private void createBoard() {
        
    }
    
    
}
