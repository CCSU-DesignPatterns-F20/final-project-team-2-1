/**
 * This class provides general framework for objects (tower, enemy) that can be placed inside a cell.
 */
public class CellObject {
    private Cell position;
    private double speed;
    
    /**
     * Returns speed
     */
    public int getSpeed(){
        return this.speed;
    }
}


