package org.whatever.brainvita.entry;

import org.whatever.brainvita.core.Board;
import org.whatever.brainvita.game.CommandParser;
import org.whatever.brainvita.game.Manager;

import java.util.Scanner;

public class Entry {

    public static void main(String[] args) {
        Board board = null;
        Manager manager = new Manager(board);
        CommandParser commandParser = new CommandParser(manager);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting New Game");
        Scanner sc = new Scanner(System.in);
        String inputLine;
        while(sc.hasNextLine()) {
            inputLine = sc.nextLine();
            if(inputLine.equals("exit")) break;
            commandParser.runCommand(inputLine);
        }
    }
}
