
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game{

    private ArrayList <Unit> army1, army2, army3, army4;
    private int playerBank;

    
    private Boolean npcRound, buyRound, attackRound;

    
    private Boolean npcRules, playerRules;
    private Boolean land1BelongsTo,land2BelongsTo,land3BelongsTo,land4BelongsTo;
    private Boolean land1Selected, land2Selected, land3Selected, land4Selected;

    
    
    public Game(){
        this.land1BelongsTo = true;
        this.land2BelongsTo = true;
        this.land3BelongsTo = false;
        this.land4BelongsTo = false;
        this.land1Selected = false;
        this.land2Selected = false;
        this.land3Selected = false;
        this.land4Selected = false;
        this.playerRules = false;
        this.npcRules = false;
        this.buyRound = true;
        this.attackRound = false;
        this.npcRound = false;
        this.playerBank = 0;
        this.army1 = new ArrayList<>();
        this.army2 = new ArrayList<>();
        this.army3 = new ArrayList<>();
        this.army4 = new ArrayList<>();
    }
    public int getArmy(int i){
        int armyUnits = 0;
        switch(i){
            case 1:
                armyUnits = army1.size();
            break;
            case 2:
                armyUnits = army2.size();
            break;
            case 3:
                armyUnits = army3.size();
            break;
            case 4:
                armyUnits = army4.size();
            break;
        }
        return armyUnits;
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
    private void addMoney(){
        for(int i = 0; i > 4; i++){
            if(getLandBelongsTo(i)){
                playerBank += 300;
            }
        }
    }
    public void useMoney(int cash){
        if(playerBank - cash > 0){
            playerBank = playerBank - cash;
        }
        else{
                String msg = "Insufficient founds! \n";
                String founds = "You only have: " + playerBank;
                JOptionPane.showMessageDialog(null, msg + founds);
        }
    }
    
    public void runGame(JPanel land1,JPanel land2,JPanel land3,JPanel land4){
        do{
           
           try{
            Thread.sleep(1000);
            }catch(InterruptedException ex){
                
            }
            
           if(buyRound){
               
           }else if(attackRound){
               
           }else if(npcRound){
               addMoney();
           }
           
        }while(this.worldNotConquered());
    }
    
    private boolean worldNotConquered(){
        if(playerRules || npcRules){
        return false;
        }else return true;
    }

    
    public void selectLand(int i){
        switch(i){
            case 1: 
                if(this.land1Selected){
                this.land1Selected = false;
                }
                else{
                this.land1Selected = true;
                }
                this.land2Selected = false;
                this.land3Selected = false;
                this.land4Selected = false;
            break;
            case 2: 
                if(this.land2Selected){
                this.land2Selected = false;
                }
                else{
                this.land2Selected = true;
                }
                this.land1Selected = false;
                this.land3Selected = false;
                this.land4Selected = false;

            break;
            case 3: 
                if(this.land3Selected){
                this.land3Selected = false;
                }
                else{
                this.land3Selected = true;
                }
                this.land1Selected = false;
                this.land2Selected = false;
                this.land4Selected = false;
            break;
            case 4: 
                if(this.land4Selected){
                this.land4Selected = false;
                }
                else{
                this.land4Selected = true;
                
                }
                this.land1Selected = false;
                this.land2Selected = false;
                this.land3Selected = false;

            break;
        }
    }
    public Boolean getLandBelongsTo(int i) {
        
        if(i == 1){ 
            return land1BelongsTo;
        }else if(i == 2){
            return land2BelongsTo;
        }else if (i == 3){
            return land3BelongsTo;
        }else {
            return land4BelongsTo;
        }    
    }
    
    public void setLandBelongsTo(Boolean b, int i) {
        switch(i){
            case 1:
                land1BelongsTo = b;
            break;
            case 2: 
                land2BelongsTo = b;
            break;
            case 3: 
                land3BelongsTo = b;
            break;                
            case 4: 
                land4BelongsTo = b;
            break;                
        }
    }

    public Boolean getLand1Selected() {
        return land1Selected;
    }

    public Boolean getLand2Selected() {
        return land2Selected;
    }

    public Boolean getLand3Selected() {
        return land3Selected;
    }

    public Boolean getLand4Selected() {
        return land4Selected;
    }
    public int getPlayerBank() {
        return playerBank;
    }
    public Boolean getNpcRound() {
        return npcRound;
    }

    public void setNpcRound(Boolean b) {
        this.npcRound = b;
    }

    public Boolean getBuyRound() {
        return buyRound;
    }

    public void setBuyRound(Boolean b) {
        this.buyRound = b;
    }

    public Boolean getAttackRound() {
        return attackRound;
    }

    public void setAttackRound(Boolean b) {
        this.attackRound = b;
    }

    public Boolean getNpcRules() {
        return npcRules;
    }

    public void setNpcRules(Boolean b) {
        this.npcRules = b;
    }

    public Boolean getPlayerRules() {
        return playerRules;
    }

    public void setPlayerRules(Boolean b ) {
        this.playerRules = b;
    }
    
    
}
