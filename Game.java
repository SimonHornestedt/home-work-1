
import java.awt.Color;
import java.util.ArrayList;

import java.util.Random;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Game{
    
    private ArrayList <Unit> army1, army2, army3, army4;
    private int playerBank, round, npcBank;
    private Boolean npcRules, playerRules;
    private Boolean land1BelongsTo,land2BelongsTo,land3BelongsTo,land4BelongsTo;
    private Boolean land1Selected, land2Selected, land3Selected, land4Selected;

    /**
     * Konstruktor till klassen Game,
     * npcn är deklarerad som false genom hela programmet medans 
     * spelaren är deklarerad som true. 
     */
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
    /**
     * Metod för att kontrollera om spelaren äger alla länder.
     * @return sant om spelaren äger alla länder
     */
    public boolean doesPlayerRule(){
        if(land1BelongsTo && land2BelongsTo && land3BelongsTo && land4BelongsTo){
            playerRules = true;  
        }else{
            playerRules = false;
        }
        return playerRules;
    }
    /**
     * Metod för att kontrollera om npcn äger alla länder.
     * @return sant om npcn äger alla länder
     */
    public boolean doesNpcRule(){
        if(!land1BelongsTo && !land2BelongsTo && !land3BelongsTo && !land4BelongsTo){
            npcRules = true;  
        }else{
            npcRules = false;
        }
        return npcRules;
    }
    /**
     * Metod för att kontrollera hur stora armeerna är. 
     * @param i är det land som skall hämtas 
     * @return returnerar hur många enheter som finns i armén
     */
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
    /**
     * Metod för att hämta arméer. 
     * @param i är det land som skall hämtas 
     * @return returnerar önskad armé
     */
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
    /**
     * metod för att lägga till Musketörer
     * @param i är det land där enheten skall läggas till
     */
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
    /**
     * Kontrollerar om det finns och drar pengar från banken 
     * @param i är hur mycket pengar som skall dras.
     * @param b är vem som ska kontrolleras. true = spelaren, false = npcn
     * @return sant om det lyckades och false om det inte fanns pengar.
     */
    public boolean hasMoney(int i,  boolean b){       
        
        if(b){
            if(playerBank - i >= 0){
            playerBank = playerBank - i;
            return true;
            }else{
            String msg = "Insufficient funds! \n";
            String funds = "You only have: " + playerBank + "c";
            JOptionPane.showMessageDialog(null, msg + funds);
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
    /**
     * metod för att lägga till Kavalerist
     * @param i är det land där enheten skall läggas till
     */
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
    /**
     * metod för att lägga till pikeenare
     * @param i är det land där enheten skall läggas till
     */
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
    /**
     * 
     * @return vilken runda det är  
     */
    public int getRound(){
        return round;
    }
    /**
     * kör npcRunda.
     * @param txaFight textArea där striden skrivs ut.
     */
    public void runNpcRound(JTextArea txaFight){
        if(this.round == 1){
            Random r = new Random();
            int unit = r.nextInt(3)+1;
            int land = r.nextInt(2);
            int cash = 0;
            System.out.println("land" + land);
            System.out.println("unit"+ unit);
            if(land == 0){
                land = 3;
            }else if(land == 1){
                land = 4;
            }switch(unit){
                case 1:
                    cash = 200;
                break;
                case 2:
                    cash = 150;
                break;
                case 3: 
                   cash = 100;
                break;
            }
            while(hasMoney(cash, false)){
                System.out.println("npc has " + npcBank +"c left");
                switch(unit){
                    case 1:
                        addCavalry(land);
                    break;
                    case 2:
                        addMusketeer(land);
                    break;
                    case 3: 
                        addPikeman(land);
                    break;
                }
                unit = r.nextInt(3)+1;
                land = r.nextInt(2); 
                System.out.println("land" + land);
                System.out.println("unit"+ unit);
                if(land == 0){
                    land = 3;
                }else if(land == 1){
                    land = 4;
                }
                
                switch(unit){
                    case 1:
                        cash = 200;
                    break;
                    case 2:
                        cash = 150;
                    break;
                    case 3: 
                       cash = 100;
                    break;
                }               
            }                                  
        }else{
            Random r = new Random();
            int unit = r.nextInt(3)+1;
            int land = r.nextInt(4)+1;
            int cash = 0;
            System.out.println("land" + land);
            System.out.println("unit"+ unit);
            
            switch(unit){
                case 1:
                    cash = 200;
                break;
                case 2:
                    cash = 150;
                break;
                case 3: 
                   cash = 100;
                break;
            }
            while(hasMoney(cash, false)){
                System.out.println("npc has " + npcBank +"c left");
                switch(unit){
                    case 1:
                        addCavalry(land);
                    break;
                    case 2:
                        addMusketeer(land);
                    break;
                    case 3: 
                        addPikeman(land);
                    break;
                }                               
                boolean npcLand = false;
                while(!npcLand){
                    land = r.nextInt(4)+1;
                switch(land){
                    case 1:
                        if(!land1BelongsTo){
                            land = 1;
                            npcLand = true;
                            break;
                        }else{
                            break;
                        }
                    case 2:
                        if(!land2BelongsTo){
                            land = 2;
                            npcLand = true;
                            break;
                        }else{
                            break;
                        }
                    case 3:
                        if(!land3BelongsTo){
                            land = 3;
                            npcLand = true;
                            break;
                        }else{
                            break;
                        }
                    case 4:
                        if(!land4BelongsTo){
                            land = 4;
                            npcLand = true;
                            break;
                        }else{
                            break;
                        }
                    default:
                        npcLand = true;
                    break;                   
                    }
                }
                unit = r.nextInt(3)+1;
                System.out.println("land" + land);
                System.out.println("unit"+ unit);
                switch(unit){
                case 1:
                    cash = 200;
                break;
                case 2:
                    cash = 150;
                break;
                case 3: 
                   cash = 100;
                break;
                }               
            }
            if(isWorldConquered()){               
                if(doesPlayerRule()){
                    String msg = "The player has won\n";
                    String msg2 = "To restart simply press > arkiv > nytt spel";
                    JOptionPane.showMessageDialog(null, msg + msg2);
                }else{
                    String msg = "The npc has won\n";
                    String msg2 = "To restart simply press > arkiv > nytt spel";
                    JOptionPane.showMessageDialog(null, msg + msg2);
                }
            }else{
                npcAttack(txaFight);
            }           
        }
        addMoney();
        round++;       
    }
    /**
     * Metod för att kontrollera hur många länder som spelaren äger.
     * 
     * @return int antal spelarägda länder
     */
    private int getNbrOfPlayerLands(){
        int playerLands = 0;
        for(int land = 1; land < 5; land++){
            if(getLandBelongsTo(land) > 0){
                playerLands++;
            }else{
                System.out.println("Player Land++");
            }
        }
        return playerLands;
    }
    /**
     * Metod för att kontrollera hur många länder som npcn äger.
     * @return int antal npcägda länder
     */
    private int getNbrOfNpcLands(){
        int npcLands = 0;
        for(int land = 1; land < 5; land++){
            if(getLandBelongsTo(land) < 0){
                npcLands++;
            }else{
                System.out.println("npcland++");
            }
        }
        return npcLands;
    }/**
     * Kontrollerar om någon har tagit över hela världen
     * @return boolean om världen är övertagen
     */
    public boolean isWorldConquered(){
        if(doesPlayerRule() || doesNpcRule()){
        return true;
        }else return false;
    }
    /**
     * Väljer land för attackrunda
     * @param i int för valt land.
     */
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
     * kontrollerar vem som äger landet
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
            case 4:
                if(land4BelongsTo){
                    return i;
                }else{
                    return -i;
                }
            default:
                return 0;                
        }       
    }    
    /**
     * Attackera valt land med spelar arme.
     * @param i int flr vilket land som är används
     * @param txaFight textArea där striden skrivs ut
     * @param attackButton den klickade attackknappen
     */
    public void attack(int i, JTextArea txaFight, JButton attackButton){
        ArrayList <Unit> attackingArmy = new ArrayList<>();
        ArrayList <Unit> defendingArmy = new ArrayList<>();
        attackingArmy = this.getArmy(getSelectedLand());
        defendingArmy = this.getArmy(i);
        Random die = new Random();       
        while(!attackingArmy.isEmpty() && !defendingArmy.isEmpty()){           
            Unit attackUnit = attackingArmy.get(0);
            Unit defendUnit = defendingArmy.get(0);
            int bonus = attackUnit.compareTo(defendUnit);
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
            defendingArmy.add(attackingArmy.get(0));
            txaFight.append("Attacker won and conquered the land\n");
            attackButton.setVisible(false);
            setLandBelongsTo(true, i);
        }else{           
            txaFight.append("Defender won and kept the land\n");
        }        
    }/**
     * Attackerar med npc armé
     * @param txaFight txa där striden skrivs ut 
     */
    public void npcAttack(JTextArea txaFight){       
        ArrayList <Unit> attackingArmy = new ArrayList<>();
        ArrayList <Unit> defendingArmy = new ArrayList<>();
        attackingArmy = getBiggestNpcArmy();
        int defendingLand = getSmallestPlayerArmy();
        switch(defendingLand){
            case 1:
                defendingArmy = army1;
                break;
            case 2:
                defendingArmy = army2;
            break;
            case 3:
                defendingArmy = army3;
            break;
            case 4:
                defendingArmy = army4;
            break;
            default:
            break;
        }
        Random die = new Random();        
        while(!attackingArmy.isEmpty() && !defendingArmy.isEmpty()){
            
            Unit attackUnit = attackingArmy.get(0);
            Unit defendUnit = defendingArmy.get(0);
            int bonus = attackUnit.compareTo(defendUnit);
            
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
            defendingArmy.add(attackingArmy.get(0));
            txaFight.append("Attacker won and conquered the land\n");
            setLandBelongsTo(false, defendingLand);
        }else{
            
            txaFight.append("Defender won and kept the land\n");
        }
    }
    /**
     * Hämtar största npc armén
     * @return arrayList för största npc armén
     */
    private ArrayList getBiggestNpcArmy(){
        ArrayList <Integer> temp = new ArrayList<> ();
        for(int i = 1; i < 5; i++){
            
            int u = getLandBelongsTo(i);
            switch(u){
                case -1:
                    temp.add(u);
                break;
                case -2:
                    temp.add(u);
                break;
                case -3:
                    temp.add(u);
                break;
                case -4:
                    temp.add(u);
                break;
                default:
                    temp.add(0);
                break;
            } 
        }
        ArrayList <Unit> biggest = new ArrayList<> ();
        for(int i: temp){
            ArrayList <Unit> tmp = new ArrayList<> ();
            switch(i){
                case -1:
                    tmp = army1;
                break;
                case -2:
                    tmp = army2;
                break;
                case -3:
                    tmp = army3;
                break;
                case -4:
                    tmp = army4;
                break; 
                default:
                break;  
            }
            if(biggest.size() < tmp.size()){
                biggest = tmp;
            }else if(biggest.size() == tmp.size()){
                biggest = tmp;
            }else{
                continue;
            }   
        }        
        return biggest;
    }
    /**
     * Hämtar minsta spelar Armé
     * @return int för vilket land som har minst armé
     */
    private int getSmallestPlayerArmy(){
        ArrayList <Integer> temp = new ArrayList<> ();
        
        int smallestLand = 0;
        
        for(int i = 1; i < 5; i++){
            
            int u = getLandBelongsTo(i);
            switch(u){
                case 1:
                    temp.add(u);
                break;
                case 2:
                    temp.add(u);
                break;
                case 3:
                    temp.add(u);
                break;
                case 4:
                    temp.add(u);
                break;
                default:
                break;
            } 
        }
        
        ArrayList <ArrayList> temp2 = new ArrayList<> ();
        for(int i: temp){
            switch(i){
                case 1:
                    temp2.add(army1);
                break;
                case 2:
                    temp2.add(army2);
                break;
                case 3:
                    temp2.add(army3);
                break;
                case 4:
                    temp2.add(army4);
                break; 
                default:
                break;  
            }
        }
        
        while(temp2.size() > 1){
            ArrayList <Unit> index0 = temp2.get(0);
            ArrayList <Unit> index1 = temp2.get(1);
            if(index0.size() > index1.size()){
                temp2.remove(0);
                temp.remove(0);
            }else{
                temp2.remove(1);
                temp.remove(1);
            }
            smallestLand = temp.get(0);
        }
        
        if(smallestLand == 0){
            ArrayList <Integer> lands = new ArrayList<> ();
            for(int i = 1; i < 5; i++){
            
            lands.add(getLandBelongsTo(i));
                for(int n : lands){
                    switch(n){
                        case 1:
                            smallestLand = 1;
                        break;
                        case 2:
                            smallestLand = 2;
                        break;
                        case 3:
                            smallestLand = 3;
                        break;
                        case 4:
                            smallestLand = 4;
                        break;
                        default:
                        break;
                    } 
                }
            
            } 
        }
        return smallestLand;
    }    
//    public void testSort(){
//       ArrayList <Unit> attackingArmy = new ArrayList<>();
//       ArrayList <Unit> defendingArmy = new ArrayList<>();
//       attackingArmy = getBiggestNpcArmy();
//       //defendingArmy = getSmallestPlayerArmy();
//       
//       System.out.println(attackingArmy.size());
//       System.out.println(defendingArmy.size());
//    } 
    /**
     * Lägger till pengar i banker.
     */
    public void addMoney(){
        addNpcMoney();
        addPlayerMoney();
    }
    /**
     * lägger till npcpengar.
     */
    public void addNpcMoney(){
        int nbrOfLands = getNbrOfNpcLands();
        npcBank = npcBank + 300*nbrOfLands;
    }
    /**
     * lägger till spelarpengar.
     */
    public void addPlayerMoney(){
        int nbrOfLands = getNbrOfPlayerLands();
        playerBank = playerBank + 300*nbrOfLands;
    }    
    /**
     * färgar om länder efter en strid.
     * @param land1 Jpanel för land 1
     * @param land2 Jpanel för land 2
     * @param land3 Jpanel för land 3
     * @param land4 Jpanel för land 4
     */
    public void reColorLands(JPanel land1,JPanel land2,JPanel land3,JPanel land4){
        ArrayList <Integer> temp = new ArrayList<> ();
        for(int i = 1; i < 5; i++){            
            int u = getLandBelongsTo(i);
            switch(u){
                case 1:
                    temp.add(u);
                break;
                case 2:
                    temp.add(u);
                break;
                case 3:
                    temp.add(u);
                break;
                case 4:
                    temp.add(u);
                break;
                case -1:
                    temp.add(u);
                break;
                case -2:
                    temp.add(u);
                break;
                case -3:
                    temp.add(u);
                break;
                case -4:
                    temp.add(u);
                break;
                default:
                    temp.add(0);
                break;
            }
        }        
        for(int n : temp){
            switch(n){
            case 1:
                land1.setBackground(Color.WHITE);
            break;
            case 2:
                land2.setBackground(Color.WHITE);
            break;
            case 3:
                land3.setBackground(Color.WHITE);
            break;
            case 4:
                land4.setBackground(Color.WHITE);
            break;
            case -1:
                land1.setBackground(Color.CYAN);
            break;
            case -2:
                land2.setBackground(Color.CYAN);
            break;
            case -3:
                land3.setBackground(Color.CYAN);
            break;
            case -4:
                land4.setBackground(Color.CYAN);
            break;
            }
        }
    }   
    /**
     * metod för att sätta ägare av ett land
     * @param b boolean för ägaren av landet
     * @param i int för vilket land som skall ändras.
     */
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
    /**
     * metoder för att returnera om landet är valt. 
     * @return boolean för om det ett land är valt 
     */
    
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
    /**
     * metod för att hämta spelarens bank
     * @return int för spelarens bank
     */
    public int getPlayerBank() {
        return playerBank;
    }
    /**
     * metod för att returnera det land som är valt. 
     * @return int för vilket land som är valt
     */
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
