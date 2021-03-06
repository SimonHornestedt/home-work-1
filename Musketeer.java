public class Musketeer extends Unit implements Comparable{

    /**
     * Medlemsvariabler.
     * @param strength enhetens styrka vid attack
     * @param defense enhetens styrka vid defense
     */
    private int strength, defense;
    
    /**
     * Konstuktor för klassen Musketeer. Denna subklass förlänger klassen
     * Unit. Klassen är en musktetör med 20 anfall och 20 försvar.
     */
    public Musketeer(){
        this.strength = 40;
        this.defense = 10;
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
        return "Musketeer ";
    }

   
    
    
}
