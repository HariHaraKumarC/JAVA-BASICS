package hari.edu.java.datastructures.arrays;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by HariHaraKumar on 9/29/2018.
 */
public class ArrayBasics {
    private static final Logger logger = Logger.getLogger(ArrayBasics.class);

    public static void main(String[] args) {
        // Single dimensional array
        int[] player1 = {5, 5, 5, 5, 5, 5, 5}; // Array Literals
        int[] player2; // Array declaration
        player2 = new int[7]; // Memory allocation
        // In java, indexing is 0 based
        player2[0] = 5; // Array initialisation. Default value for int is 0
        logger.debug("Single Dimensional Array: Player 1 Array Initial Values : " + Arrays.toString(player1));
        logger.debug("Single Dimensional Array: Player 2 Array Initial Values : " + Arrays.toString(player2));
        //Multi Dimensional Array (two)
        int[][] players = {{5, 5, 5, 5, 5, 5, 5}, {5, 5, 5, 5, 5, 5, 5}};
        logger.debug("Multi Dimensional Array: Players Array Initial Values : " + Arrays.deepToString(players));
    }
}
