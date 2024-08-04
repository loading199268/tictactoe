package tictactoe;

public class Administrator {
    private final GameTable gameTable = GameTable.getInstance();

    public boolean isGameFinished() {
        Container[][] field = this.gameTable.getField();
        for (int i = 0; i < field.length; i++) {
            if ((field[i][0].value == field[i][1].value) && (field[i][1].value == field[i][2].value) && (field[i][2].value != ' ')) {
                System.out.println(field[i][i] + " wins");
                nullField();
                return true;
            } else if ((field[0][i].value == field[1][i].value) && (field[1][i].value == field[2][i].value) && (field[2][i].value != ' ')) {
                System.out.println(field[0][i] + " wins");
                nullField();
                return true;
            }
        }
        if ((field[0][0].value == field[1][1].value) && (field[1][1].value == field[2][2].value) && (field[2][2].value != ' ')) {
            System.out.println(field[0][0] + " wins");
            nullField();
            return true;
        } else if ((field[0][2].value == field[1][1].value) && (field[1][1].value == field[2][0].value) && (field[2][0].value != ' ')) {
            System.out.println(field[1][1] + " wins");
            nullField();
            return true;
        }

        for (Container[] chars : field) {
            for (Container c : chars) {
                if (c.value == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Draw");
        nullField();
        return true;
    }

    public void nullField() {
        Container[][] c = gameTable.getField();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j].value = ' ';
            }
        }
    }

    public void printField() {
        gameTable.printField();
    }
}
