package src.cell;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

/**
 * This is to group the cell component and invoking a method on multiple
 * components once.
 */
public class CellComposite extends CellComponent {
    protected List<CellComponent> subComponents = new ArrayList<CellComponent>();

    /**
     * Adds Cell component to the array list
     * 
     * @param cellComponent to be added
     */
    public void add(CellComponent cellComponent) {
        if (cellComponent != null) {
            this.subComponents.add(cellComponent);
        }

    }

    /**
     * Replaces the CellComponent based on index
     * @param index of the list
     * @param cellComponent to be added
     */
    public void set(int index, CellComponent cellComponent) {
        this.subComponents.set(index, cellComponent);
    }

    /**
     * Removes Cell component from the array list
     * @param cellComponent to be removed
     */
    public void remove(CellComponent cellComponent) {
        if (this.subComponents.contains(cellComponent)) {
            this.subComponents.remove(cellComponent);
        }
    }

    /**
     * Gets the child component based on its index
     * @param index used to retrive the specific child from the list
     */
    public CellComponent getSubComponentAtIndex(int index) {
        return this.subComponents.get(index);
    }

    /**
     * This returns color of the last CellComponent in the list if exists
     */
    @Override
    public Color draw() {
        if (subComponents.isEmpty()) return null;
        else return subComponents.get(subComponents.size()-1).draw();
    }

    /**
     * Prints all components in the composite
     */
    public void printAllComponenents() {
        for (int i = 0; i < this.subComponents.size(); i++) {
            System.out.println(this.getSubComponentAtIndex(i).toString());
        }
    }

    /**
     * returns itself (list)
     */
    public List<CellComponent> getSubComponents() {
        return this.subComponents;
    }
    

    /**
     * returns itself (list)
     */
    @Override
    public CellComposite composite() {
        return this;
    }

}