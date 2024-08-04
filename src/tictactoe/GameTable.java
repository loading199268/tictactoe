package tictactoe;

public class GameTable {
    private final Container[][] field = new Container[3][3];

    public Container[][] getField() {
        return field;
    }

    private GameTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = new Container() ;
            }
        }
    };
    private static GameTable instance;

    public static GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }

    public void printField() {

        System.out.println("---------");
        for (Container[] containers : field) {
            System.out.print("| ");
            for (Container container : containers) {
                System.out.print(container + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean turn(Container conteyner, PlayerNum playerNum) {
        if (conteyner.value != ' ') {
            return false;
        }
        conteyner.value = playerNum.getValue();
        return true;
    }

    public Container[][] copyField() {
        Container[][] result = new Container[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                result[i][j] = new Container(field[i][j].value);
            }
        }
        return result;
    }
}
