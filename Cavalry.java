
public class Cavalry extends Unit implements Comparable{
    
    private int strength, defense;
    
    public Cavalry(){
        this.defense = 20;
        this.strength = 20;
    }
    
    
    
    @Override
    public int compareTo(Unit other) {
        final int EQUAL = 0;
        final int GREATER = 1;
        final int LESSER = -1;
        
        if(this.getStr() > other.getDef()){
            return GREATER; 
        }else if(this.getStr() < other.getDef()){
            return LESSER;
        }else{
            return EQUAL;
        } 
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
        return "Cavalry ";
    }

    

   
    
}
