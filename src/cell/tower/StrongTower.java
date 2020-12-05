package src.cell.tower;

import java.awt.Color;
/**
 * This class implements strong tower
 */

import java.awt.Color;
import java.util.Random;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.enemy.EnemyPrototype;
public class StrongTower extends BaseTower {

    public StrongTower(Cell cell, IteratorInterface<Cell> cellPathIterator){
        super(cell, cellPathIterator);
        this.damage = 2.0;
    }

    /**
     * This method will shoot enemy when fully realoaded.
     * Strong tower has 10% chance to shoot again
     */
    @Override
    public void shoot(EnemyPrototype enemy) {
        System.out.println("Strong tower shoots");
        enemy.setHealth(enemy.getHealth()-this.getDamage());
        var cell = enemy.getPosition();
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
     */
    @Override
    public Color draw(){
        // System.out.println("Purple Box on " + position.getLocation());
        return Color.CYAN;
    }
    
}
