package src.cell.enemy;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import java.awt.Color;

/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    public FastEnemy(CellList<Cell> cellPath){
        super(cellPath);
        this.speed = 5;
    }

    public FastEnemy(Enemy clone){
        super(clone);
    }


    /**
    * Clones the enemy instance
    */
    @Override
    public FastEnemy clone(){
        return new FastEnemy(this);
    }

    /**
    * Draws fast enemy as red box
    */
    @Override
    public Color draw() {
        // System.out.println("Red Box on " + this.position.getLocation());
        return Color.RED;
    }

}