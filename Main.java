import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.abstractfactory.TowerFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.CellComposite;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.HealthDecorator;
import src.cell.tower.DamageDecorator;
import src.cell.tower.Tower;

/**
 * @author XiaoWei Chen, Radoslaw Konopka, Daniel Pobidel, Trung Minh Tri Nguyen
 */
public class Main {
    public static void main(String args[]) {
		 Game.play();
    }
}