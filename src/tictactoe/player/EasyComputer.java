package tictactoe.player;

import tictactoe.Container;
import tictactoe.GameTable;
import tictactoe.PlayerNum;

import java.util.Random;

public class EasyComputer implements Player{
    private final GameTable gameTable = GameTable.getInstance();
    public static Random random = new Random();
    private PlayerNum playerNum;


    @Override
    public void play() {
        boolean successTurn = false;
        while (!successTurn) {
            Container container =  gameTable.getField()[random.nextInt(3)][random.nextInt(3)];
            successTurn = gameTable.turn(container, playerNum);
        }
        System.out.println("Making move level \"easy\"");
    }

    @Override
    public Player setPlayerNum(PlayerNum playerNum) {
        this.playerNum = playerNum;
        return this;
    }
}
