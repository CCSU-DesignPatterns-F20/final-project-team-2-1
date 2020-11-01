/**
* This is the parent class of the Enemy, Tower, and the Cell
*/
public abstract class CellComponent{
    private CellComposite parent;
    protected double speed;
    protected Cell position;

    public CellComposite composite(){
        return null;
    }

    /**
     * return the parent object
     */
    public CellComposite getParent(){
        return this.parent;
    }

    
    /**
     * This changes the speed of the componet
     * @param newSpeed is the new speed
     */
    public void changeSpeed(int newSpeed){

    }
}
