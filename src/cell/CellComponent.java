package src.cell;
import java.awt.Color;
/**
* This is the parent class of the Enemy, Tower, and the Cell
*/
public abstract class CellComponent{
    private CellComposite parent;
    protected Cell position;

    /**
     * Takes in position and puts the CellComponent in it
     * @param Position for the CellComponent
     */
    public CellComponent(Cell position){
        this.position = position;
        this.position.add(this);

    }

    public CellComponent(){}

    /**
     * return the parent object
     */
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
     * Draws the Component on the UI Board
     */
    public abstract Color draw();

    /**
     * Draws the Component on the UI Board
     */
    public Cell getPosition(){
        return this.position;
    }

    /**
     * Draws the Component on the UI Board
     */
    public void setPosition(Cell position){
        this.position = position;
        this.position.add(this);
    }
}
