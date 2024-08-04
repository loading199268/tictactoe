package tictactoe.player;

import tictactoe.Container;
import tictactoe.GameTable;
import tictactoe.PlayerNum;

public class HardComputer implements Player{
    private final GameTable gameTable = GameTable.getInstance();
    private PlayerNum playerNum;

    @Override
    public void play() {
        gameTable.turn(tryToTurn(gameTable.getField()), playerNum);
        System.out.println("Making move level \"hard\"");
    }

    public Container tryToTurn(Container[][] array) {
        int maxValue = Integer.MIN_VALUE;
        Container contWin = null;
        for (Container[] conteyners : array) {
            for (Container conteyner : conteyners) {
                if (conteyner.value == ' ') {
                    conteyner.value = playerNum.getValue();
                    int value = miniMax(array, playerNum, true, false, 90);
                    conteyner.value = ' ';
                    if (maxValue <= value) {
                        maxValue = value;
                        contWin = conteyner;
                    }
                }
            }
        }
        return contWin;
    }

    public int miniMax(Container[][] field, PlayerNum playerNum, boolean switcH, boolean isMax, int depth) {
        int value = checkTurn(field, playerNum, switcH, depth);
        if (value != 0) {
            return value;
        }
        playerNum = playerNum.another();
        switcH = !switcH;
        if(isMax) {
            int max = Integer.MIN_VALUE;
            for (Container[] conteyners : field) {
                for (Container conteyner : conteyners) {
                    if (conteyner.value == ' ') {
                        conteyner.value = playerNum.getValue();
                        max = Math.max(max, miniMax(field, playerNum, switcH, false, depth - 1));
                        conteyner.value = ' ';
                    }
                }
            }
            return max;
        }

        int min = Integer.MAX_VALUE;
        for (Container[] conteyners : field) {
            for (Container conteyner : conteyners) {
                if (conteyner.value == ' ') {
                    conteyner.value = playerNum.getValue();
                    min = Math.min(min, miniMax(field, playerNum, switcH, true, depth - 1));
                    conteyner.value = ' ';
                }
            }
        }
        return min;
    }

    private void print(Container[][] arr, PlayerNum playerNum, boolean s) {
        System.out.printf("!!!!!!!!!!! %s %s", playerNum.getValue(), s);
        System.out.println();
        for (Container[] conteyners : arr) {
            System.out.print("| ");
            for (Container conteyner : conteyners) {
                System.out.print(conteyner + " ");
            }
            System.out.println("|");
        }
        System.out.println("!!!!!!!!!!!");
    }


    public int checkTurn(Container[][] field, PlayerNum playerNum, boolean switcH, int depth) {
        Integer result = null;
        for (int i = 0; i < field.length; i++) {
            if ((field[i][0].value == field[i][1].value) && (field[i][1].value == field[i][2].value) && (field[i][2].value != ' ')) {
                if (field[i][0].value == playerNum.getValue()) {
                    result = switcH ? 10 : -10;
                }
            } else if ((field[0][i].value == field[1][i].value) && (field[1][i].value == field[2][i].value) && (field[2][i].value != ' ')) {
                if (field[0][i].value == playerNum.getValue()) {
                    result = switcH ? 10 : -10;
                }
            }

        }

        if ((field[0][0].value == field[1][1].value) && (field[1][1].value == field[2][2].value) && (field[2][2].value != ' ')) {
            if (field[0][0].value == playerNum.getValue()) {
                result = switcH ? 10 : -10;
            }
        } else if ((field[0][2].value == field[1][1].value) && (field[1][1].value == field[2][0].value) && (field[2][0].value != ' ')) {
            if (field[1][1].value == playerNum.getValue()) {
                result = switcH ? 10 : -10;
            }
        }

        for (int i = 0; i < field.length && result == null; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].value == ' ') {
                    result = 0;
                    break;
                }
            }

        }
        result = result == null ? -1 : result;
        return result * depth;

    }


    @Override
    public Player setPlayerNum(PlayerNum playerNum) {
        this.playerNum = playerNum;
        return this;
    }
}
