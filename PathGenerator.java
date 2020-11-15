
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
    */
    public static int[][] create10by10EasyPath() {
        return new int[][] { 
            { 1, 0 }, 
            { 1, 1 }, 
            { 1, 2 }, 
            { 1, 3 }, 
            { 1, 4 }, 
            { 1, 5 }, 
            { 1, 6 }, 
            { 1, 7 }, 
            { 1, 8 },
            { 1, 9 } };
    }

    /**
    * Path for board 10 x 10 size
    * Hard path/Hard game level
    */
    public static int[][] create10by10HardPath() {
        // todo
        return null;
    }
}
