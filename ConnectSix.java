package edu.kit.informatik;

public class ConnectSix {
    
    /**
     * main method
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            int size = Integer.parseInt(args[1]);
            int players  = Integer.parseInt(args[2]);
            if (args == null || args.length != 3 || (!args[0].equals("standard") && !args[0].equals("torus")) 
                    || ((size != 18) && (size != 20))  || (players < 2) || (players > 4)) {
                throw new IllegalArgumentException();
            }
            Board board = (args[0].equals("torus")) ? new TorusBoard(size) : new StandardBoard(size);
            boolean quitProgram = false;
            while (!quitProgram) {
                try {
                    String line = Terminal.readLine();
                    if (line.length == 0 || String.valueOf(line.charAt(line.length() - 1)).equals(";")) {
                        throw new IllegalArgumentException();
                    }
                    String[] command = line.split(" ", 2);
                    String[] param = (command.length > 1) ? command[1].split(";") : null;
                    switch (command[0]) {
                        case "place":
                            if (param == null || param.length != 4) {
                                throw new IllegalArgumentException();
                            }
                            int player = (board.getTurns() % players == 0) ? players : board.getTurns() % players; 
                            if (board.isFull() || board.getWon()) {
                                throw new IllegalArgumentException();
                            }
                            board.setState(param[0], param[1], param[2], param[3], "P" + String.valueOf(player));
                            break;
                        case "rowprint":
                            if (param == null || param.length != 1) {
                                throw new IllegalArgumentException();
                            }
                            board.rowPrint(Integer.parseInt(param[0]));
                            break;
                        case "colprint":
                            if (param == null || param.length != 1) {
                                throw new IllegalArgumentException();
                            }
                            board.columnPrint(Integer.parseInt(param[0]));
                            break;
                        case "print":
                            if (param != null) {
                                throw new IllegalArgumentException();
                            }
                            board.print();
                            break;
                        case "state":
                            if (param == null || param.length != 2) {
                                throw new IllegalArgumentException();
                            }
                            Terminal.printLine(board.getState(param[0], param[1]));
                            break;
                        case "reset":
                            if (param != null) {
                                throw new IllegalArgumentException();
                            }
                            board = (args[0].equals("torus")) ? new TorusBoard(size) : new StandardBoard(size);
                            Terminal.printLine("OK");
                            break;
                        case "quit":
                            if (param != null) {
                                throw new IllegalArgumentException();
                            }
                            quitProgram = true;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    Terminal.printError("Please enter a valid command");
                }
            }
        } catch (IllegalArgumentException e) {
            Terminal.printError("Please enter valid arguments");
        }

    }
}