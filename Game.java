
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Game{
    
    private ArrayList <Unit> army1, army2, army3, army4;
    private int playerBank, round, npcBank;
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
        this.round = 1;
        this.npcBank = 1000;
        this.playerBank = 1000;
        this.army1 = new ArrayList<>();
        this.army2 = new ArrayList<>();
        this.army3 = new ArrayList<>();
        this.army4 = new ArrayList<>();
    }
    public boolean doesPlayerRule(){
        if(land1BelongsTo && land2BelongsTo && land3BelongsTo &&land4BelongsTo){
            playerRules = true;  
        }else{
            playerRules = false;
        }
        return playerRules;
    }
    public boolean doesNpcRule(){
        if(!land1BelongsTo && !land2BelongsTo && !land3BelongsTo && !land4BelongsTo){
            npcRules = true;  
        }else{
            npcRules = false;
        }
        return npcRules;
    }
    public int getArmySize(int i){
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
    public ArrayList getArmy(int i){
        switch(i){
            default:
                return this.army1;
            case 2:
                return this.army2;
            case 3:
                return this.army3;
            case 4:
                return this.army4;
        }
    }
    public void addMusketeer(int i){
       
        if(hasMoney(150, i)){
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
            System.out.println("för lite pengar");
        }
        
        
    }
    private boolean hasMoney(int i, int owner){
        switch(owner){
            case 1:
                owner = getLandBelongsTo(owner);
            break;
            case 2:
                owner = getLandBelongsTo(owner);
            break;
            case 3:
                owner = getLandBelongsTo(owner);
            break;
            case 4:
                owner = getLandBelongsTo(owner);
            break;
        }
        if(owner > 0){
        if(playerBank - i >= 0){
            playerBank = playerBank - i;
            return true;
        }else{
            String msg = "Insufficient founds! \n";
            String founds = "You only have: " + playerBank + "c";
            JOptionPane.showMessageDialog(null, msg + founds);
            return false;
        }
        }else{
            if(npcBank - i >= 0){
            npcBank = npcBank - i;
            return true;
        }else{
            return false;
        }
        }
    }
    public void addCavalry(int i){
        if(hasMoney(200, i)){
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
            System.out.println("för lite pengar");
        }              
    }
    
    public void addPikeman(int i){
        if(hasMoney(100, i)){
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
            System.out.println("för lite pengar");
        }
    }   
    public int getRound(){
        return round;
    }
    public void runNpcRound(){
        if(this.round == 1){
            Unit u = new Pikeman();
            army3.add(u);
            army3.add(u);
            army3.add(u);
        }else{
            
        }
        this.round++;
    }
    private boolean isWorldConquered(){
        if(doesPlayerRule() || doesNpcRule()){
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
                    return -i;
                }
            case 2:
                if(land2BelongsTo){
                    return i;
                }else{
                    return -i;
                }
            case 3:
                if(land3BelongsTo){
                    return i;
                }else{
                    return -i;
                }
            default:
                if(land4BelongsTo){
                    return i;
                }else{
                    return -i;
                }
        }       
    }
    public void testButton(){
        while(!army1.isEmpty()){
            System.out.println(army1.get(0).toString());
            army1.remove(0);
        }
    }
    public void attack(int i, JTextArea txaFight){
        ArrayList <Unit> attackingArmy = new ArrayList<>();
        ArrayList <Unit> defendingArmy = new ArrayList<>();
        attackingArmy = this.getArmy(getSelectedLand());
        defendingArmy = this.getArmy(i);
        Random die = new Random();
        String s = new String();
        while(!attackingArmy.isEmpty() && !defendingArmy.isEmpty()){
            
            Unit attackUnit = attackingArmy.get(0);
            Unit defendUnit = defendingArmy.get(0);
            int bonus = attackUnit.compareTo(defendUnit);
            System.out.println(bonus);
            int attackRoll = die.nextInt(5)+1;
            int defendRoll = die.nextInt(5)+1;
            attackRoll = attackRoll + bonus;
            
            txaFight.append("Attacking " +attackUnit.toString()+ "rolled " + 
                    Integer.toString(attackRoll) +" against defending " + 
                 defendUnit.toString() + " which rolled " + 
                    Integer.toString(defendRoll) + "\n");
            if(attackRoll > defendRoll){
                defendingArmy.remove(0);
               
                txaFight.append(attackUnit.toString() +"killed " + 
                        defendUnit.toString() + "\n");
            }else if(attackRoll < defendRoll){
                attackingArmy.remove(0);
                
                txaFight.append(defendUnit.toString() +"killed " + 
                        attackUnit.toString() + "\n");
            }else{

                txaFight.append("Both units rolled " + Integer.toString(attackRoll)+ "Reroll!" + "\n");
            }
         
        }
        if(defendingArmy.isEmpty()){
            
            txaFight.append("Attacker won and conquered the land");
            setLandBelongsTo(true, i);
        }else{
            
            txaFight.append("Defender won and kept the land");
        }
        
    }
    public void npcAttack(int i){
        
    }
    private int compareArmySize(ArrayList attackingArmy, ArrayList defendingArmy){
        if(attackingArmy.size() < defendingArmy.size()){
            return attackingArmy.size();
        }else{
            return defendingArmy.size();
        }
    }
    public Color colorLands(){
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
    public int getSelectedLand(){
        if(land1Selected){
            return 1;
        }else if(land2Selected){
            return 2;
        }else if(land3Selected){
            return 3;
        }else if(land4Selected){
            return 4;
        }else{
            String msg = "No land selected \n";
            String msg2 = "Please select a land and try agian!";
            JOptionPane.showMessageDialog(null, msg + msg2);
            return 0;
        }
    }
}
