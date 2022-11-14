package com.example.snakeAndLadder.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Board {

    private static Board board;
    private Cell[] cells;

    private Board() {
    }
    private Board(int size) {
        this.cells = new Cell[size];
    }

    public static Board init(int size, List<Snake> snakes, List<Ladder> ladders) {
        if (board == null || board.size() < size) {
            board = new Board(size);
        }

        for (Snake snake : snakes) {
            board.getCells()[snake.getStartPosition()] = new Cell(snake);
        }
        for (Ladder ladder : ladders) {
            board.getCells()[ladder.getStartPosition()] = new Cell(ladder);
        }
        for (int i = 0; i < size; i++) {
            if (board.getCells()[i] == null || !board.getCells()[i].isHasAdjustment()) {
                board.getCells()[i] = new Cell(i);
            }
        }
        return board;
    }

    protected int size() {
        return cells.length;
    }

    public int calculateNextPosition(int currentPos, int diceValue) {
        if (currentPos + diceValue > board.size()) {
            return currentPos;
        }
        if (currentPos + diceValue == board.size()) {
            return board.size();
        }
        return board.getCells()[currentPos + diceValue].adjust(diceValue);
    }

}
