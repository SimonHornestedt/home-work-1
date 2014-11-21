public class Pikeman extends Unit implements Comparable{
    /**
     * Medlemsvariabler.
     * @param strength enhetens styrka vid attack
     * @param defense enhetens styrka vid defense
     */
    private int strength, defense;
    
    /**
     * Konstuktor för klassen Pikeman. Denna subklass förlänger klassen
     * Unit och inplementerar Comparable. Klassen är en pikenare med 10 anfall och 40 försvar.
     */
    public Pikeman(){
        this.strength = 10;
        this.defense = 40;
    }
    
    /**
     * Metod för att jämföra enheters attack mot försvar.
     * @param other den Unit som enheten jämförs med
     * @return int, 1 om enheten har större attack än jämförd enhets försvar
     * 0 om enheten har samma attack som jämförd enhets försvar
     * -1 om enheten har lägre attack än jämförd enhets försvar
     */
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
    /**
     * skickar styrkan hos enheten
     * @return int för styrkan
     */
    @Override
    public int getStr() {
        return strength;
    }
    /**
     * skickar försvaret hos enheten
     * @return int för enhetens försvar
     */
    @Override
    public int getDef() {
        return defense;
    }
    /**
     * Metod för att hämta vilken sorts enhet det är
     * @return String med enhetens namn;
     */
    @Override
    public String toString(){
        return "Pikeman ";
    }

    
}
