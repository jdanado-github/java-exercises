package com.everlaw;

/**
 * Main Board class. Manages the info about the board
 * @author Jose Danado (jose.danado@gmail.com)
 */
public class Board {
    byte[][] board = new byte[8][8];

    public Board() {
        board = new byte[8][8];
        for(int i=0; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                board[i][j] = 2;
            }
        }
        board[3][3] = 0;
        board[3][4] = 1;
        board[4][3] = 1;
        board[4][4] = 0;
    }

    private char getCharacter(int i, int j) {
        if (board[i][j] == 0) {
            return 'O';
        } else if(board[i][j] == 1) {
            return 'X';
        } else {
            return ' ';
        }
    }

    private boolean isValid(int i, int j, byte value, boolean change) {
        int oposite = (value + 1) % 2;
        //System.out.println(String.format("%s,%s,%s",i,j, value));
        boolean val = false;
        if(((i -1) >= 0 && (i-2) >= 0 &&
                board[i-1][j] == oposite &&
                board[i-2][j] == value)) {
            if(change)
                board[i-1][j] = value;
            val = true;
        }

        if((i + 1) < 8 && (i+2) < 8 &&
                board[i+1][j] == oposite &&
                board[i+2][j] == value) {
            if(change)
                board[i+1][j] = value;
            val = true;
        }

        if((j -1) >= 0 && (j-2) >= 0 &&
                board[i][j-1] == oposite &&
                board[i][j-2] == value) {
            if(change)
                board[i][j-1] = value;
            val = true;
        }

        if((j+1) < 8 && (j+2) < 8 &&
                board[i][j+1] == oposite &&
                board[i][j+2] == value) {
            if(change)
                board[i][j+1] = value;
            val = true;
        }

        if ((i-1) >= 0 && (i-2) >= 0 &&
                (j-1) >= 0 && (j-2) >= 0 &&
                board[i-1][j-1] == oposite &&
                board[i-2][j-2] == value) {
            if(change)
                board[i-1][j-1] = value;
            val = true;
        }

        if((i+1) < 8 && (i+2) < 8 &&
                (j+1) < 8 && (j+2) < 8 &&
                board[i+1][j+1] == oposite &&
                board[i+2][j+2] == value) {
            if(change)
                board[i+1][j+1] = value;
            val = true;
        }

        if((i+1) < 8 && (i+2) < 8 &&
                (j-1) >=0 && (j-2) >= 0 &&
                board[i+1][j-1] == oposite &&
                board[i+2][j-2] == value) {
            if(change)
                board[i+1][j-1] = value;
            val = true;

        }

        if ((i-1) >=0 && (i+2) >=0 &&
                (j-1) < 8 && (j+2) < 8 &&
                board[i-1][j+1] == oposite &&
                board[i-2][j+2] == value) {
            if(change)
                board[i-1][j+1] = value;
            val = true;
        }
        return val;
    }

    public boolean setPosition(int i, int j, byte value) {
        boolean ret = isValid(i, j, value, true);
        if (ret) {
            board[i][j] = value;

        }
        return ret;
    }

    public boolean canPlay(byte value) {
        for(int i=0; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                if(board[i][j] == 2 && isValid(i, j, value, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String wins() {
        int countBlack = 0;
        int countWhite = 0;

        for(int i=0; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                if(board[i][j] == 0) {
                    countWhite++;
                } else if(board[i][j] == 1) {
                    countBlack++;
                }
            }
        }
        if(countWhite == countBlack) {
            return "Tie";
        } else if(countWhite > countBlack) {
            return "White wins";
        } else {
            return "Black wins";
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(' ');
        for (int i=0; i < 8; i++) {
            sb.append((char) ('a' + i));
        }
        sb.append('\n');
        for (int j=0; j < 8; j++) {
            sb.append(j+1);
            for(int k=0; k < 8; k++) {
                sb.append(getCharacter(j, k));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}