package src.cell.tower;

import java.awt.Color;
import java.util.Random;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.enemy.EnemyPrototype;

/**
 * This class implements strong tower
 */
public class StrongTower extends BaseTower {

    /**
     * Takes in position and puts the CellComponent in it
     * @param Position for the CellComponent
     * @param Path list
     */
    public StrongTower(Cell cell, IteratorInterface<Cell> cellPathIterator){
        super(cell, cellPathIterator);
        this.damage = 2;
    }

    /**
     * This method will shoot enemy.
     * Strong tower has 10% chance to shoot again.
     * @param Enemy to be shot at
     */
    @Override
    public void shoot(EnemyPrototype enemy) {
        System.out.println("Strong tower shoots");
        enemy.setHealth(enemy.getHealth()-this.getDamage());
        Random  r = new Random(); 
        float roll = r.nextFloat();
        double max = .10;
        System.out.println(max + " " + roll);
        if (roll < max){
            System.out.println("Strong tower shoots again");
            enemy.setHealth(enemy.getHealth()-this.getDamage());
        }
    }

    /**
     * Draws strong tower as purple box
     * @return returns color corresponding to this CellComponent
     */
    @Override
    public Color draw(){
        return Color.CYAN;
    }
    
}
