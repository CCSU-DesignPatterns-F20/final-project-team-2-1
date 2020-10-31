
public class Cell extends BoardComposite{
    private CellObject cellObject;
    private boolean isPath;
    private int x;
    private int y;

    public Cell(int x, int y, boolean isPath) {
        this.x = x;
        this.y = y;
        this.isPath = isPath;
    }

    public void placeOnCell(CellObject cellObject) {
        this.cellObject = cellObject;
    }
}
