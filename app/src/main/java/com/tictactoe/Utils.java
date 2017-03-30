package com.tictactoe;

import com.tictactoe.model.CellItem;

import java.util.ArrayList;

/**
 * Created by Divya on 3/30/2017.
 */

public class Utils {

    static String value0, value1, value2, value3, value4, value5, value6, value7, value8;

    public static String winner;
    public static Boolean shouldShowX = true;


    public static Boolean checkWinner(ArrayList<CellItem> cellItems) {

        setValues(cellItems);


        if (checkHorizontal()) {
            return true;
        }

        if (checkVertical()) {
            return true;
        }

        if (checkDiagonal()) {
            return true;
        }


        return false;
    }

    private static void setValues(ArrayList<CellItem> cellItems) {
        value0 = cellItems.get(0).getValue();
        value1 = cellItems.get(1).getValue();
        value2 = cellItems.get(2).getValue();
        value3 = cellItems.get(3).getValue();
        value4 = cellItems.get(4).getValue();
        value5 = cellItems.get(5).getValue();
        value6 = cellItems.get(6).getValue();
        value7 = cellItems.get(7).getValue();
        value8 = cellItems.get(8).getValue();
    }

    public static Boolean checkIfGameOver(ArrayList<CellItem> cellItems) {
        int count = 0;
        for (int i = 0; i < cellItems.size(); i++) {
            if (cellItems.get(i).getValue().equals("P"))
                count++;
        }
        if (count == 0)
            return true;

        return false;
    }

    private static Boolean checkHorizontal() {
        if (value0.equals("X") && value1.equals("X") && value2.equals("X")) {
            winner = "X";
        }

        if (value3.equals("X") && value4.equals("X") && value5.equals("X")) {
            winner = "X";
        }

        if (value6.equals("X") && value7.equals("X") && value8.equals("X")) {
            winner = "X";
        }

        if (value0.equals("O") && value1.equals("O") && value2.equals("O")) {
            winner = "O";
        }

        if (value3.equals("O") && value4.equals("O") && value5.equals("O")) {
            winner = "O";
        }

        if (value6.equals("O") && value7.equals("O") && value8.equals("O")) {
            winner = "O";
        }

        if (winner != null)
            return true;
        return false;
    }

    private static Boolean checkVertical() {
        if (value0.equals("X") && value3.equals("X") && value6.equals("X")) {
            winner = "X";
        }

        if (value1.equals("X") && value4.equals("X") && value7.equals("X")) {
            winner = "X";
        }

        if (value2.equals("X") && value5.equals("X") && value8.equals("X")) {
            winner = "X";
        }

        if (value0.equals("O") && value3.equals("O") && value6.equals("O")) {
            winner = "O";
        }

        if (value1.equals("O") && value4.equals("O") && value7.equals("O")) {
            winner = "O";
        }

        if (value2.equals("O") && value5.equals("O") && value8.equals("O")) {
            winner = "O";
        }

        if (winner != null)
            return true;
        return false;
    }

    private static Boolean checkDiagonal() {
        if (value0.equals("X") && value4.equals("X") && value8.equals("X")) {
            winner = "X";
        }

        if (value2.equals("X") && value4.equals("X") && value6.equals("X")) {
            winner = "X";
        }

        if (value0.equals("O") && value4.equals("O") && value8.equals("O")) {
            winner = "O";
        }

        if (value2.equals("O") && value4.equals("O") && value6.equals("O")) {
            winner = "O";
        }

        if (winner != null)
            return true;
        return false;
    }

    public static void setShouldShowX(Boolean bool) {
        shouldShowX = bool;
    }

    public static Boolean getShouldShowX() {
        return shouldShowX;
    }
}
