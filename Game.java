
import java.util.ArrayList;

public class Game{

    private ArrayList <Unit> army1, army2, army3, army4;
    private Boolean npcRound;
    
    public Game(){
        this.createBoard();
        this.army1 = new ArrayList<>();
        this.army2 = new ArrayList<>();
        this.army3 = new ArrayList<>();
        this.army4 = new ArrayList<>();
    }
    
    
    public void addMusketeer(){
        
        Unit u = new Musketeer();
        army1.add(u);
        
        
    }
    public void addCavalry(int i){
        Unit u = new Cavalry();
        switch(i){
            case 1:
                army1.add(u);
            break;
            case 2:
                army2.add(u);
            break;
            case 3:
                army3.add(u);
            break;
            default:
                army4.add(u);
            break;
        }
        
        
    }
    public void addPikeman(){
        Unit u = new Pikeman();
        
        army1.add(u);
        
        
    }

    private void createBoard() {
        
    }
    
    
}
