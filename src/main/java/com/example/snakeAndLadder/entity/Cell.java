package com.example.snakeAndLadder.entity;

import lombok.Getter;

@Getter
public class Cell {
    private final Adjustment adjustment;
    private final boolean hasAdjustment;

    public Cell(int currentPosition) {
        this(new Ladder(currentPosition, currentPosition));
    }

    public Cell(Adjustment adjustment) {
        this.adjustment = adjustment;
        this.hasAdjustment = true;
    }

    public int adjust(int diceValue) {
        return hasAdjustment ? adjustment.move() : adjustment.getStartPosition() + diceValue;
    }
}
