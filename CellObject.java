/**
 * This class provides general framework for objects (tower, enemy) that can be placed inside a cell.
 */
public abstract class CellObject extends BoardComponent{

    private Cell position;
    private double speed;
    
    /**
     * Returns speed
     */
    public int getSpeed(){
        return this.speed;
    }
    /**
    * set speed
    */
    public void setSpeed(double speed){
      this.speed = speed;
    }        
    /**
     * Returns position
     */
    public int getPosition(){
        return this.position;
    }
    /**
    * set position
    */
    public void setSpeed(Cell position){
      this.position = position;
    } 
}


