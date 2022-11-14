package com.example.snakeAndLadder.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static final int PLAYER_A = 0;
    private static final int PLAYER_B = 1;

    @Test
    void play(){
        Game game = new Game(2, BoardTest.getSnakes(), BoardTest.getLadders());
        assertEquals(0, game.currentPosition(PLAYER_A));
        assertEquals(0, game.currentPosition(PLAYER_B));
        assertEquals(3, game.play(PLAYER_A, 3));
        assertEquals(14, game.play(PLAYER_B, 4));
        assertEquals(5, game.play(PLAYER_A, 2));
        assertEquals(8, game.play(PLAYER_A, 3));
        assertEquals(7, game.play(PLAYER_B, 3));
        assertEquals(8, game.currentPosition(PLAYER_A));
        assertEquals(8, game.play(PLAYER_A, 93));
        assertEquals(99, game.play(PLAYER_A, 91));
        assertEquals(99, game.play(PLAYER_A, 2));
        assertEquals(100, game.play(PLAYER_A, 1));
    }
}