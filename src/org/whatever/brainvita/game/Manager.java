package org.whatever.brainvita.game;

import org.whatever.brainvita.core.Board;
import org.whatever.brainvita.data.Move;

import java.util.Stack;

public class Manager {
    private Board board;
    private Stack<Move> undo, redo;

    public Manager(Board board) {
        this.board = board;
        this.undo = new Stack<>();
        this.redo = new Stack<>();
    }

    public void applyMove(Move move) throws Exception {
        if(board.isValid(move)) {
            board.apply(move);
            undo.push(move);
            redo = new Stack<>();
        }
        else {
            throw new Exception("Move is not valid");
        }
    }

    public boolean undo() {
        if(undo.size() == 0) {
            return false;
        }
        Move move = undo.pop();
        board.undo(move);
        redo.push(move);
        return true;
    }

    public boolean redo() {
        if(redo.size() == 0) {
            return false;
        }
        Move move = redo.pop();
        if(board.isValid(move)) {
            board.apply(move);
            undo.push(move);
            redo = new Stack<>();
        }
        return true;
    }

    public String getBoard() {
        return board.toString();
    }
}
