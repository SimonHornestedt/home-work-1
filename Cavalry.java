
public class Cavalry extends Unit implements Comparable{
    
    private int strength, defense;
    
    public Cavalry(){
        this.defense = 20;
        this.strength = 15;
    }
    
    
    
    @Override
    public int compareTo(Comparable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStr() {
        return strength;
    }
    @Override
    public int getDef() {
        return defense;
    }
    @Override
    public String toString(){
        return "Cavalry: ";
    }

    

   
    
}
