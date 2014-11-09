
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Game{

    private ArrayList <Unit> army1, army2, army3, army4;
    private int playerBank;
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
       
        this.playerBank = 1000;
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
        if(hasMoney(150)){
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
        }else{
            String msg = "Insufficient founds! \n";
            String founds = "You only have: " + playerBank;
            JOptionPane.showMessageDialog(null, msg + founds);
        }
        
        
    }
    private boolean hasMoney(int i){
        if(playerBank - i >= 0){
            playerBank = playerBank - i;
            return true;
        }else{
            return false;
        }
    }
    public void addCavalry(int i){
        if(hasMoney(200)){
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
        }else{
            String msg = "Insufficient founds! \n";
            String founds = "You only have: " + playerBank;
            JOptionPane.showMessageDialog(null, msg + founds);
        }
        
        
    }
    public void addPikeman(int i){
        if(hasMoney(100)){
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
        }else{
            String msg = "Insufficient founds! \n";
            String founds = "You only have: " + playerBank;
            JOptionPane.showMessageDialog(null, msg + founds);
        }
    }
    private void addMoney(){
        for(int i = 0; i > 4; i++){
            //if(getLandBelongsTo(i)){
              //  playerBank += 300;
            //}
        }
    }

    public void runNpcRound(){
        
    }
    private boolean isWorldConquered(){
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
    /**
     * 
     * @param i = det land som skall kontrolleras
     * @return landets nummer om det är spelaren land
     */
    public int getLandBelongsTo(int i) {

        switch(i){
            case 1:
                if(land1BelongsTo){
                    return i;
                }else{
                    return 0;
                }
            case 2:
                if(land2BelongsTo){
                    return i;
                }else{
                    return 0;
                }
            case 3:
                if(land3BelongsTo){
                    return i;
                }else{
                    return 0;
                }
            default:
                if(land4BelongsTo){
                    return i;
                }else{
                    return 0;
                }
        }       
    }
    public void attack(int i){
        
    }
    public Color colorLand(){
        Color c = Color.WHITE;
        for(int i = 1; i< 5; i++){
            ArrayList <Integer> temp = new ArrayList<>();
            temp.add(getLandBelongsTo(i));
            for(int u : temp){
                    switch(u){
                        case 0:
                            c = Color.CYAN;
                        break;
                        
                        default:
                            c = Color.WHITE;
                        break;
                        }
            }    
        }
        return c;
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

    public Boolean isLand1Selected() {
        return land1Selected;
    }

    public Boolean isLand2Selected() {
        return land2Selected;
    }

    public Boolean isLand3Selected() {
        return land3Selected;
    }

    public Boolean isLand4Selected() {
        return land4Selected;
    }
    public int getPlayerBank() {
        return playerBank;
    }
 

    public Boolean doesNpcRule() {
        
        return npcRules;
    }

    public Boolean doesPlayerRule() {
        return playerRules;
    }

    
    
    
}
