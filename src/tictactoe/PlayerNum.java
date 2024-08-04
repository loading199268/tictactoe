package tictactoe;

public enum PlayerNum {
    PLAYER_ONE('X') {
        @Override
        public PlayerNum another() {
            return PLAYER_TWO;
        }
    },
    PLAYER_TWO('O') {
        @Override
        public PlayerNum another() {
            return PLAYER_ONE;
        }
    };

    final Character value;
    PlayerNum(Character x) {
        value = x;
    }

    public Character getValue() { //тут мы просим дать Х или О, класс сам решает что отдать
        return value;
    }

    public abstract PlayerNum another();

}
