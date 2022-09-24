package com.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.array.TraverseArray.traverseTheArrayElements;
import static org.junit.Assert.*;

public class TraverseArrayTest {

    /**
     * The test case to verify if the given input cell is already visited and traversed.
     */
    @Test
    public void verifyTheCellIsAlreadyVisited() {
        int row = 0;
        int column = 0;
        Boolean[][] cell = new Boolean[2][2];
        cell[0][0] = true;  //Suppose the cell is already visited so value is true

        assertTrue("The Cell is Already Visited", !TraverseArray.ifCellAlreadyVisited(cell, row, column));
    }


    /**
     * The below test case is used for checking if the array length exceeds while traversing.
     */
    @Test
    public void verifyTheCellIsOutOfBounds() {
        int row = 4;
        int column = 4;
        Boolean[][] cell = new Boolean[4][4];

        assertFalse("The Cell is Out Of Bounds", TraverseArray.ifCellAlreadyVisited(cell, row, column));
    }

    /**
     * The below test case verifies if the traversed array matches with the expected result.
     */
    @Test
    public void printTheTraversedArray(){

        int[][] array = { { 0, 1, -1, 5},
                { 2, 3, -2, 6},
                { 4, 6, 5, 8},
                { 13, 14, 15,12}};


        List<Integer>  expectedList = Arrays.asList(0, 1, -1, 5, 6, 8, 12, 15, 14, 13, 5, 6, 4, -2, 3, 2);
        List<Integer> traversedList = TraverseArray.traverseTheArrayElements(array);

        assertEquals(traversedList,expectedList);
    }

}
