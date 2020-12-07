package src.cell.tower;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.enemy.EnemyPrototype;

import java.awt.Color;

/**
 * This class implements weak tower
 */

public class WeakTower extends BaseTower {
    /**
     * Takes in position and puts the CellComponent in it
     * @param Position for the CellComponent
     * @param Path list
     */
    public WeakTower(Cell cell, IteratorInterface<Cell> cellPathIterator){
        super(cell, cellPathIterator);
        this.damage = 1;
    }
    
    
    /**
     * This method will shoot enemy.
     * @param Enemy to be shot at
     */
    @Override
    public void shoot(EnemyPrototype enemy) {
        System.out.println("Weak tower shoots");
        this.setReloadLeft(this.getSpeed());
        System.out.printf("enemy before shot " + enemy.getHealth());
        enemy.setHealth(enemy.getHealth()-this.getDamage());
        System.out.println("enemy health after shot " + enemy.getHealth());
    }
    /**
     * Draws tower as blue box
     */
    @Override
    public Color draw(){
        return Color.BLUE;
    }
}
