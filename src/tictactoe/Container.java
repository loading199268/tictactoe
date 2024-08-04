package tictactoe;

public class Container {
    public char value = ' ';

    public Container(char value) {
        this.value = value;
    }

    public Container() {
    }

    @Override
    public String toString() {
        return value + "";
    }
}
