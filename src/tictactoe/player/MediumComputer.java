package tictactoe.player;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tictactoe.Container;
import tictactoe.GameTable;
import tictactoe.PlayerNum;

public class MediumComputer implements Player{
    private final GameTable gameTable = GameTable.getInstance();
    private final Random random = new Random();
    private PlayerNum playerNum;


    @Override
    public void play() {
        if (!turnMediumComputer()) {
            computerMediumRandom();
        }
        System.out.println("Making move level \"medium\"");
    }

    @Override
    public Player setPlayerNum(PlayerNum playerNum) {
        this.playerNum = playerNum;
        return this;
    }


    public boolean tryToTurn(Container X1, Container X2, Container X3) {
        int qX = 0;
        int qO = 0;
        Container[][] field = gameTable.getField();
        Container[] inputWin = new Container[3];
        List<Container> emptyContainer = new ArrayList<>();

        inputWin[0] = X1;
        inputWin[1] = X2;
        inputWin[2] = X3;
        for (Container container : inputWin) {
            if (container.value == ' ') {
                emptyContainer.add(container);
            }
            if (container.value == 'X') {
                qX++;
            }
            if (container.value == 'O') {
                qO++;
            }
        }
        if ((qX == 2 || qO == 2) && emptyContainer.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean turnMediumComputer() {
        Container[][] array = gameTable.getField();
        Container[][] cf = gameTable.copyField();
        if (tryToTurn(cf[0][0], cf[0][1], cf[0][2])) {
            Container[] array1 = {array[0][0], array[0][1], array[0][2]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[1][0], cf[1][1], cf[1][2])) {
            Container[] array1 = {array[1][0], array[1][1], array[1][2]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[2][0], cf[2][1], cf[2][2])) {
            Container[] array1 = {array[2][0], array[2][1], array[2][2]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[0][0], cf[1][0], cf[2][0])) {
            Container[] array1 = {array[0][0], array[1][0], array[2][0]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[0][1], cf[1][1], cf[2][1])) {
            Container[] array1 = {array[0][1], array[1][1], array[2][1]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[0][2], cf[1][2], cf[2][2])) {
            Container[] array1 = {array[0][2], array[1][2], array[2][2]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[0][0], cf[1][1], cf[2][2])) {
            Container[] array1 = {array[0][0], array[1][1], array[2][2]};
            turn(array1);
            return true;
        } else if (tryToTurn(cf[0][2], cf[1][1], cf[2][0])) {
            Container[] array1 = {array[0][2], array[1][1], array[2][0]};
            turn(array1);
            return true;
        } else {
            return false;
        }
    }

    public void computerMediumRandom() {
        boolean successTurn = false;
        while (!successTurn) {
            Container container = gameTable.getField()[random.nextInt(3)][random.nextInt(3)];
            successTurn = gameTable.turn(container, playerNum);
        }
    }

    public void turn(Container[] array) {
        for (int i = 0; i < array.length; i++) {
            gameTable.turn(array[i], playerNum);
        }
    }
}
