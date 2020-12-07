package src.cell.enemy;

import java.awt.Color;

import src.board.iterator.CellList;
import src.cell.Cell;

/**
 * This class implements slow enemy
 */
public class SlowEnemy extends Enemy {

    /**
     * Creates Path Iterator and sets speed
     * @param Path iterator list
     */
    public SlowEnemy(CellList<Cell> cellPath){
        super(cellPath);
        this.speed = 1;
    }

    /**
     * Creates the same enemy as clone
     * @param Path iterator list
     */
    public SlowEnemy(EnemyPrototype clone){
        super(clone);
    }

    /**
    * Clones the enemy instance
    * @return new HealthDecorator with the same attributes values
    */
    @Override
    public SlowEnemy clone(){
        return new SlowEnemy(this.pathCellList);
    }

    /**
    * Draws slow enemy as orange box
    * @return returns color corresponding to this CellComponent
    */
    @Override
    public Color draw() {
        return Color.ORANGE;
    }

}