package src.cell.enemy;

import src.board.iterator.CellList;
import src.cell.Cell;
import java.awt.Color;

/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    /**
     * Creates Path Iterator and sets speed
     * @param Path iterator list
     */
    public FastEnemy(CellList<Cell> cellPath){
        super(cellPath);
        this.speed = 5;
    }

    /**
     * Creates the same enemy as clone
     * @param Path iterator list
     */
    public FastEnemy(Enemy clone){
        super(clone);
    }


    /**
    * Clones the enemy instance
    * @return new HealthDecorator with the same attributes values
    */
    @Override
    public FastEnemy clone(){
        return new FastEnemy(this);
    }

    /**
    * Draws fast enemy as red box
    * @return returns color corresponding to this CellComponent
    */
    @Override
    public Color draw() {
        return Color.RED;
    }

}