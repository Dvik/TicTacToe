package com.tictactoe.model;

/**
 * Created by Divya on 3/30/2017.
 */

public class CellItem {

    Integer row, column;
    String value;

    public CellItem(Integer row, Integer column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}
