package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraverseArray {

    /**
     * The below Class is to set the row and column value from the input array after
     * the elements of the array are looped via stack
     */
    public static class arrayCell{

        int row;
        int column;

        arrayCell(int row, int column){
            this.row = row;
            this.column = column;
        }
    }


    /** The below method is used to verify if the specified element of the array
     * is already visited and added to the list
     * @param cell will have boolean value
     * @param row
     * @param column
     */
    public static Boolean ifCellAlreadyVisited(Boolean[][] cell, int row, int column){

        //In case the value is out of bounds
        if (row < 0 || column < 0 ||
                row >= 4 || column >= 4)
            return false;

        //In case the cell is already visited
        return !cell[row][column];
    }


    /** the below method is used for traversing the array elements
     * and print them as list based on the direction specified.
     * @param inputArray contains the array with the elements
     * @return return the traversed elements as list of integers.
     */
    public static List<Integer> traverseTheArrayElements(int[][] inputArray){


        int row = 0,column = 0;
        int[] traverseRowDirection = {0, 1, 0, -1};
        int[] traverseColumnDirection = {-1, 0, 1 , 2};
        List<Integer> traversedList = new ArrayList<>();
        Boolean[][] cell = new Boolean[4][4];


        for(int i=0; i< inputArray.length; i++){
            for(int j = 0; j < inputArray.length; j++){
                cell[i][j] = false;
            }
        }

        Stack<arrayCell> traverseStack = new Stack<>();
        traverseStack.push(new arrayCell(row, column));

        while(!traverseStack.empty()){
            arrayCell currentCell = traverseStack.pop();

            row = currentCell.row;
            column = currentCell.column;


            if (!ifCellAlreadyVisited(cell, row, column))
                continue;


            cell[row][column] = true;


            traversedList.add(inputArray[row][column]);


            for(int i = 0; i < 4; i++)
            {
                int nextRowValue = row + traverseRowDirection[i];
                int nextColumnValue = column + traverseColumnDirection[i];
                traverseStack.push(new arrayCell(nextRowValue, nextColumnValue));
            }

        }

        System.out.println(traversedList);

        return traversedList;
    }

    /**
     * @param args
     */
    public static void main(String[] args){

        int[][] inputArray = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }};


        traverseTheArrayElements(inputArray);
    }
}
