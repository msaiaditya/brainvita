package org.whatever.brainvita.game;

import org.whatever.brainvita.data.Move;
import org.whatever.brainvita.data.Position;

/**
    Valid inputs:
    1. move srcX srcY tgtX tgtY
    2. undo
    3. redo
 **/

public class CommandParser {

    private Manager manager;

    public CommandParser(Manager manager) {
        this.manager = manager;
    }

    public void runCommand(String input) {
        String[] args = input.split(" ");
        if(args.length == 0) {
            printError("args are empty");
        }
        switch (args[0]) {
            case "move":
                apply(input);
                break;
            case "undo":
                manager.undo();
                break;
            case "redo":
                manager.redo();
                break;
            default:
                printError("Unknown argument");
        }
    }

    private void apply(String input) {
        try {
            Move move = buildMove(input);
            manager.applyMove(move);
            printSuccess(manager.getBoard());
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private Move buildMove(String input) throws Exception {
        String[] args = input.split(" ");
        if(!isValidForMove(args)) throw new Exception("Invalid args for Move");
        Position src = new Position(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Position trg = new Position(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        Move move = new Move(src, trg);
        return move;
    }

    private boolean isValidForMove(String[] args) {
        if(args.length != 5) return false;
        for(int i=1;i<5;i++) {
            try {
                Integer.parseInt(args[i]);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    private void printError(String error) {
        System.out.println("Error : " + error);
    }

    private void printSuccess(String success) {
        System.out.println("Success : \n" + success);
    }

}
