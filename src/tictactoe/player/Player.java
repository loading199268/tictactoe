package tictactoe.player;


import tictactoe.PlayerNum;

public interface Player {
    void play();

    Player setPlayerNum(PlayerNum playerNum);
}
