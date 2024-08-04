package tictactoe;

import tictactoe.player.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

import static tictactoe.PlayerNum.PLAYER_ONE;
import static tictactoe.PlayerNum.PLAYER_TWO;


public class StartGame {
    private final Map<String, Supplier<Player>> map = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Administrator administrator = new Administrator();

    public StartGame() {
        map.put("hard", HardComputer::new);
        map.put("easy", EasyComputer::new);
        map.put("medium", MediumComputer::new);
        map.put("user", HumanPlayer::new);
    }


    private void play(String input) {
        String[] array = input.split(" ");
        if(array.length != 3) {
            System.out.println("Bad parameters!");
            return;
        }
        if (array[1].equals("user")) {
            GameTable.getInstance().printField();
        }
        Player player1 = map.get(array[1]).get().setPlayerNum(PLAYER_ONE);
        Player player2 = map.get(array[2]).get().setPlayerNum(PLAYER_TWO);
        int turn = 1;

        do {
            if (turn % 2 == 1) {
                player1.play();
            } else {
                player2.play();
            }
            turn++;

            administrator.printField();
        } while (!administrator.isGameFinished());

    }

    public void startGame() {
        while (true) {
            System.out.println("Input command: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            if (input.startsWith("start")) {
                play(input);
                continue;
            }
            System.out.println("Bad parameters!");
        }
    }
}
