package src.cell;

import java.util.ArrayList;
import java.util.List;

import src.cell.enemy.EnemyPrototype;

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
        if (cellComponent != null)
            this.subComponents.add(cellComponent);
    }

    /**
     * Removes Cell component from the array list
     * 
     * @param cellComponent to be removed
     */
    public void remove(CellComponent cellComponent) {
        if (this.subComponents.contains(cellComponent))
            this.subComponents.remove(cellComponent);
    }

    /**
     * Gets the child component based on its index
     * 
     * @param index used to retrive the specific child from the list
     */
    public CellComponent getChild(int index) {
        return this.subComponents.get(index);
    }

    /**
     * This draw shapes for all components. *Starts from 0 to skip the cell itself.
     */
    @Override
    public Color draw() {
        if (subComponents.isEmpty()) return null;
        else return subComponents.get(subComponents.size()-1).draw();
    }

    /**
     * returns itself (list)
     */
    public void printAllComponenents() {
        for (int i = 0; i < this.subComponents.size(); i++) {
            System.out.println(this.getChild(i).toString());
        }
    }

    public List<CellComponent> getSubComponents() {
        return this.subComponents;
    }

    public void removeIfDead(EnemyPrototype enemy){
        if (enemy.getHealth() <= 0){
            this.remove(enemy);
            System.out.println("Enemy is dead");
            enemy.position = null;
            while(enemy.getCellPathIterator().hasNext()) enemy.getCellPathIterator().next();
        }
    }

    /**
     * returns itself (list)
     */
    @Override
    public CellComposite composite() {
        return this;
    }

}