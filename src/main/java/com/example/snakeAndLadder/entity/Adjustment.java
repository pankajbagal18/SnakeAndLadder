package com.example.snakeAndLadder.entity;

import lombok.Getter;

@Getter
public abstract class Adjustment implements BoardMovements {
    private int startPosition;
    private int endPosition;

    @Override
    public int move() {
        return endPosition;
    }

    public Adjustment(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
