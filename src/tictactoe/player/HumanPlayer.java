package tictactoe.player;

import tictactoe.GameTable;
import tictactoe.PlayerNum;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Scanner scanner = new Scanner(System.in);
    private final GameTable gameTable = GameTable.getInstance();
    private PlayerNum playerNum;


    @Override
    public Player setPlayerNum(PlayerNum playerNum) {
        this.playerNum = playerNum;
        return this;
    }

    @Override
    public void play() {

        boolean successTurn = false;
        while (!successTurn) {
            System.out.println("Enter the coordinates: ");
            int[] inputInt = getInputInt();
            successTurn = gameTable.turn(
                    gameTable.getField()[inputInt[0]][inputInt[1]],
                    playerNum
            );
            if (!successTurn) {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public int[] getInputInt() {
        int[] ar = new int[2];
        for (int i = 0; i < ar.length; i++) {
            if (scanner.hasNextInt()) {
                ar[i] = scanner.nextInt() - 1;
                if (ar[i] > 2 || ar[i] < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
            }
            scanner.nextLine();
            i = -1;
        }
        return ar;
    }
}
