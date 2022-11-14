package com.example.snakeAndLadder.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void init() {
        List<Snake> snakes = getSnakes();
        List<Ladder> ladder = getLadders();
        final Board myBoard = Board.init(100, snakes, ladder);
        assertEquals(100, myBoard.size());
        assertTrue(myBoard.getCells()[17].isHasAdjustment());
        assertTrue(myBoard.getCells()[4].isHasAdjustment());
    }

    public static List<Snake> getSnakes() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(17, 7));
        return snakes;
    }

    public static List<Ladder> getLadders() {
        List<Ladder> ladder = new ArrayList<>();
        ladder.add(new Ladder(4, 14));
        return ladder;
    }
}