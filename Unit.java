public abstract class Unit implements Comparable{
    
    /** 
     * Konstruktor för den abstracta klassen Unit. Den innehåller alla 
     * nödvändiga metoder för alla subklasser. Den implementerar även 
     * gränssnittet Comparable.
     */
    public Unit(){  
    }
    /**
     * Metod för att hämta styrka.
     * @return int för styrkan hos den subklass som metoden körs på
     */
    public abstract int getStr();
    /**
     * Metod för att hämta försvar.
     * @return int för försvaret hos den subklass som metoden körs på
     */
    public abstract int getDef();
    
    /**
     * Metod för att hämta namnet på enheten.
     * @return String med namnet på enheten.
     */
    @Override
    public abstract String toString();
    
   
    


}
