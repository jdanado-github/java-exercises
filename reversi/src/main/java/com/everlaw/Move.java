package com.everlaw;

/**
 * Deals with UI and board coordinates.
 * @author Jose Danado (jose.danado@gmail.com)
 */
public class Move {
    private int i;
    private int j;

    public Move(String col, String row) {
        i = row.charAt(0) - '1';
        j = col.charAt(0) - 'a';
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
