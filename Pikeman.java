public class Pikeman extends Unit implements Comparable{

    private int strength, defense;
    
    
    public Pikeman(){
        this.strength = 10;
        this.defense = 40;
        
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
        return "Pikeman ";
    }

    
}
