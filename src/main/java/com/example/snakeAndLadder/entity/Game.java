package com.example.snakeAndLadder.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int BOARD_SIZE = 100;
    private final Board board;
    private final List<Player> players;

    public Game(int numberOfPlayers, List<Snake> snakes, List<Ladder> ladders) {
        board = Board.init(BOARD_SIZE, snakes, ladders);
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i));
        }
    }

    public void reset() {
        players.forEach(player -> player.setCurrentPosition(0));
    }

    public int play(int playerNumber, int diceValue) {
        final Player currentPlayer = players.get(playerNumber);
        int nextPos = board.calculateNextPosition(currentPlayer.getCurrentPosition(), diceValue);
        if (BOARD_SIZE == nextPos) {
            currentPlayer.setCurrentPosition(BOARD_SIZE);
            return BOARD_SIZE;
        }
        currentPlayer.setCurrentPosition(nextPos % BOARD_SIZE);
        return currentPlayer.getCurrentPosition();
    }

    public boolean doesPlayerWon(int playerNumber) {
        return BOARD_SIZE == players.get(playerNumber).getCurrentPosition();
    }

    public int currentPosition(int playerNumber) {
        return players.get(playerNumber).getCurrentPosition();
    }

}
