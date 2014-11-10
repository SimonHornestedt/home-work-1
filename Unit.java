public abstract class Unit implements Comparable{
    
    
    Unit(){
       nbrOfUnits++;
    }
    public static int nbrOfUnits;
    
    public abstract int getStr();
    public abstract int getDef();
    
    
    @Override
    public abstract String toString();
    
   
    


}
