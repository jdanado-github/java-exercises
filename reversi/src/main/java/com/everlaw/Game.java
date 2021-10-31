package com.everlaw;

/**
 * Manages input, player turns, board update and checks for the end of the game.
 * @author Jose Danado (jose.danado@gmail.com)
 */
public class Game {
    private byte turn;
    private Board board;
    private Input input;

    public Game() {
        turn = 1;
        board = new Board();
        input = new Input();
    }

    public void run() {

        while(true) {
            System.out.println(board.toString());
            System.out.println(turn == 0 ? "White -> " : "Black -> ");
            Move move = input.getMove();
            boolean isValid = board.setPosition(move.getI(), move.getJ(), turn);
            if(isValid) {
                turn = (byte) ((turn + 1) % 2);

                if(!board.canPlay(turn)) {
                    turn = (byte) ((turn + 1) % 2);
                    if(!board.canPlay(turn)) {
                        System.out.print(board.wins());
                        break;
                    }
                }
            } else {
                System.out.println("Invalid Move");
            }

        }
    }
}
