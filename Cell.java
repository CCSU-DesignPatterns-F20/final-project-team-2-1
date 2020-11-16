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

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isPath = false;
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
     * Turns cell into path or nonpath
     * @param new Value
     */
    public void setPath(boolean isPath) {
        this.isPath = isPath;
    }


    /**
     * Returns hash code based on locataion and path
     */
    public int hashCode(){
        int hash = 0;
        hash += this.x;
        hash += this.y;
        hash += this.isPath ? 1 : 0;
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
     * Returns Cell location.
     */
    public String getLocation(){
        return "Cell: x: " + x + " y: " + y; 
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

    /**
     * Draws the Cell and the components currently residenting on this cell
     */
    @Override
    public void draw(){
        System.out.println("Green Box on " + this.getLocation());
        for (int i = 0; i < this.subComponents.size(); i++){
            this.getChild(i).draw();
        }
    }
}
