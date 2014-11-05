
import java.util.ArrayList;

public class Game{

    private ArrayList <Unit> army1, army2, army3, army4;
    private Boolean npcRound, buyRound, attackRound;
    private Boolean npcRules, playerRules;
    private Boolean land1BelongsTo,land2BelongsTo,land3BelongsTo,land4BelongsTo;
    
    public Game(){
        this.land1BelongsTo = true;
        this.land2BelongsTo = true;
        this.land3BelongsTo = false;
        this.land4BelongsTo = false;
        this.playerRules = false;
        this.npcRules= false;
        this.army1 = new ArrayList<>();
        this.army2 = new ArrayList<>();
        this.army3 = new ArrayList<>();
        this.army4 = new ArrayList<>();
    }
    
    
    
    public void addMusketeer(int i){
        
        Unit u = new Musketeer();
        
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
    public void addPikeman(int i){
        
        Unit u = new Pikeman();
        
        
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

    
    public void runGame(){
        do{
           if(buyRound){
               
           }else if(attackRound){
               
           }else if(npcRound){
               
           }else{
               
           }
        }while(this.notWorldConquered());
    }
    
    private boolean notWorldConquered(){
        if(playerRules || npcRules){
        return false;
        }else return true;
    }

    public Boolean getLand1BelongsTo() {
        return land1BelongsTo;
    }

    public void setLand1BelongsTo(Boolean b) {
        this.land1BelongsTo = b;
    }

    public Boolean getLand2BelongsTo() {
        return land2BelongsTo;
    }

    public void setLand2BelongsTo(Boolean b) {
        
        this.land2BelongsTo = b;
    }

    public Boolean getLand3BelongsTo() {
        return land3BelongsTo;
    }

    public void setLand3BelongsTo(Boolean b) {
        this.land3BelongsTo = b;
    }

    public Boolean getLand4BelongsTo() {
        return land4BelongsTo;
    }

    public void setLand4BelongsTo(Boolean b) {
        this.land4BelongsTo = b;
    }
    
    
    
}
