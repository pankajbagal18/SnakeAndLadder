package com.example.snakeAndLadder.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final int id;
    @Setter
    private int currentPosition;

    public Player(int id) {
        this.id = id;
        this.currentPosition = 0;
    }
}
