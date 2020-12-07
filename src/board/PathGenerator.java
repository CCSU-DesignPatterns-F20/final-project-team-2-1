package src.board;
/**
 * This class contains possible combinations of path for specific board sizes.
 * The output is a matrix integer of size [number of paths Cells] x [2] 
 * where each row represents individual Cell's coordination, first columns represents x axis,
 * and second row represents y axis.
 * IMPORTANT TO NOTE: The order of coordinates matter since they determine the order the enemies will move**
 * Additional paths combinations can be easily added in.
 */

public class PathGenerator {

    /**
    * Path for board 10 x 10 size
    * Easy path/Easy game level
    * @return the array list of the cell path
    */
    public static int[][] create10by10EasyPath() {
        return new int[][] { 
            { 1, 0 }, 
            { 1, 1 }, 
            { 1, 2 }, 
            { 1, 3 }, 
            { 1, 4 }, 
            { 2, 4 },
            { 2, 5 },
            { 2, 6 },
            { 2, 7 },
            { 2, 8 },
            { 2, 9 } };
    }

    /**
    * Path for board 10 x 10 size
    * Hard path/Hard game level
    * @return null by default
    */
    public static int[][] create10by10HardPath() {
        return new int[][] { 
            { 1, 0 }, 
            { 1, 1 }, 
            { 1, 2 }, 
            { 1, 3 }, 
            { 1, 4 }, 
            { 2, 4 },
            { 2, 5 },
            { 2, 6 },
            { 2, 7 },
            { 2, 8 },
            { 2, 9 },
            { 3, 9 },
            { 4, 9 },
            { 5, 9 } };
    }
}
