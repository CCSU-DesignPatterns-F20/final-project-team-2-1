/**
 * This class is a specific position on the map. It will hold a tower or enemy object.
 */
public class Cell extends CellComposite{
    private CellComponent cellComponent;
    private boolean isPath;
    private int x;
    private int y;

    /**
     * abstract instructor 
     * @param x axis location
     * @param y axis location
     * @param path for enemies to travel
     */
    public Cell(int x, int y, boolean isPath) {
        this.x = x;
        this.y = y;
        this.isPath = isPath;
    }

    /**
     * Bounds the cell with the tower or enemy
     * @param Tower/Enemy
     */
    public void placeOnCell(CellComponent cellObject) {
        this.cellComponent = cellObject;
    }

    /**
     * Returns x location of Cell
     */
    public int getX(){
        return this.x;
    }

    /**
     * Returns y location of Cell
     */
    public int getY(){
        return this.y;
    }

    /**
     * Returns isPath
     */
    public boolean getPath() {
        return this.isPath;
    }


    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += this.x;
        hash += this.y;
        hash += this.isPath ? 1 : 0;
        hash += (this.cellComponent != null ? this.cellComponent.hashCode():0);
        return hash;
    }
    
    /**
     * Compare objects based on locataion and path
     * @param Object to compare
     */
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        else if (this == other) {
            return true;
        }
        else if (other instanceof Cell){
            Cell otherObj = (Cell) other;
            if (this.getX() == otherObj.getX() && this.getY() == otherObj.getY() && this.getPath() == otherObj.getPath()){
                return true;
            }
        }
       return false;
    }


    /**
     * Returns object as string representation.
     */
    public String toString(){
        String returnString = "Cell: x: " + x + " y: " + y; 
        if (this.isPath){
            returnString = returnString + " (Path)";
        }
        if (this.cellComponent!= null){
            returnString = returnString + "Contains Object: " + cellComponent.toString();
        }
        return returnString;
    }
}
