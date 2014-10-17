public abstract class Army{
    
    protected int nbrOfUnits;
    
    
    public Army(){
        
        this.nbrOfUnits = 0;
       
    }
    
    
    public abstract void addUnit();
    
    public abstract void killUnit();
    
}
