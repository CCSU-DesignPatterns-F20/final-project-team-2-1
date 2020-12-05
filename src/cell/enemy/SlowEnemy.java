package src.cell.enemy;

import java.awt.Color;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;

/**
 * This class implements slow enemy
 */
public class SlowEnemy extends Enemy {

    public SlowEnemy(CellList<Cell> cellPath){
        super(cellPath);
        this.speed = 1;
    }

    
    /**
    * Clones the enemy instance
    */
    @Override
    public SlowEnemy clone(){
        return new SlowEnemy(this.pathCellList);
    }

    /**
    * Draws slow enemy as orange box
    */
    @Override
    public Color draw() {
        // System.out.println("Orange Box on " + this.position.getLocation());
        return Color.ORANGE;
    }

}