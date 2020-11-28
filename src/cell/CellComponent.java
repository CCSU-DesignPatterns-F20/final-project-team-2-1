package src.cell;
/**
* This is the parent class of the Enemy, Tower, and the Cell
*/
public abstract class CellComponent{
    private CellComposite parent;
    protected Cell position;

    public CellComponent(Cell position){
        this.position = position;
        this.position.add(this);
    }

    public CellComponent(){

    }

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
    public abstract void draw();

    /**
     * Draws the Component on the UI Board
     */
    public Cell getPosition(){
        return this.position;
    }
}
