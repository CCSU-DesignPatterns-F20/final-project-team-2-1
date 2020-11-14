import java.util.ArrayList;
import java.util.List;

/**
 * This is to group the cell component and invoking a method on multiple
 * components once.
 */
public class CellComposite extends CellComponent{
    protected List<CellComponent> subComponents = new ArrayList<CellComponent>();
    

    /**
     * Adds Cell component to the array list
     * @param cellComponent to be added
     */
    public void add(CellComponent cellComponent){
        if (cellComponent != null)
            this.subComponents.add(cellComponent);
    }

    /**
     * Removes Cell component from the array list
     * @param cellComponent to be removed 
     */
    public void remove(CellComponent cellComponent){
        this.subComponents.remove(cellComponent);
    }
    
    /**
     * Gets the child component based on its index
     * @param index used to retrive the specific child from the list
     * */
    public CellComponent getChild(int index){
        return this.subComponents.get(index);
    }

    /**
     * This draw shapes for all components. 
     * *Starts from 0 to skip the cell itself.
     */
    public void draw(){
        for (int i = 0; i < this.subComponents.size(); i++){
            System.out.println(this.getChild(i).toString());
        }
    }

    /**
     * returns itself (list)
     */
    public void printAllComponenents(){
        for (int i = 0; i < this.subComponents.size(); i++){
            System.out.println(this.getChild(i).toString());
        }
    }

    /**
     * returns itself (list)
     */
    public CellComposite composite(){
        return this;
    }

}