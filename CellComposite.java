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

    }

    /**
     * Removes Cell component from the array list
     * @param cellComponent to be removed 
     */
    public void remove(CellComponent cellComponent){

    }
    
    /**
     * Gets the child component based on its index
     * @param index used to retrive the specific child from the list
     * */
    public CellComponent getChild(int index){
        return this.subComponents.get(index);
    }

    /**
     * 
     */
    public CellComposite composite(){
        return this;
    }
}