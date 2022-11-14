package com.example.snakeAndLadder.service;

import com.example.snakeAndLadder.entity.Game;
import com.example.snakeAndLadder.entity.Ladder;
import com.example.snakeAndLadder.entity.Snake;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameRunner {

    // not a best way think other way
    private Game currentGame;

    public void start(int numberOfPlayers) {
        currentGame = new Game(numberOfPlayers, makeRandomSnakes(), makeRandomLadders());
    }

    public List<Snake> makeRandomSnakes() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(17, 7));
        return snakes;
    }

    public List<Ladder> makeRandomLadders() {
        List<Ladder> ladder = new ArrayList<>();
        ladder.add(new Ladder(4, 14));
        return ladder;
    }

    public int play(int playerNumber, int diceValue) {
        return currentGame.play(playerNumber, diceValue);
    }

    public boolean doesPlayerWon(int playerNumber) {
        return currentGame.doesPlayerWon(playerNumber);
    }
}
