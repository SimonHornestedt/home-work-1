public class Musketeer extends Unit implements Comparable{

    private int strength, defense;
    
    
    public Musketeer(){
        this.strength = 50;
        this.defense = 5;
    }

    @Override
    public int compareTo(Comparable o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getStr() {
        return strength;
    }
    @Override
    public int getDef() {
        return defense;
    }

   
    
    
}
