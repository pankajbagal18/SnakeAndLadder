package com.example.snakeAndLadder.apis;

import com.example.snakeAndLadder.service.GameRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/snakeladder")
public class SnakeLadderAPI {

    @Autowired
    private GameRunner runner;

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> start(@RequestBody String request) {
        if (request != null && request.equalsIgnoreCase("START")) {
            runner.start(2);
            return ResponseEntity.ok("READY");
        }
        return ResponseEntity.badRequest().body("Send Valid Request");
    }

    @PostMapping("/start")
    public ResponseEntity<String> start() {
        runner.start(2);
        return ResponseEntity.ok("READY");
    }

    @PostMapping("/play")
    public ResponseEntity<String> play(@RequestParam("diceValue") int diceValue,@RequestParam("playerNumber") int playerNumber) {
        final int nextPosition = runner.play(playerNumber, diceValue);
        if (runner.doesPlayerWon(playerNumber)) {
            return ResponseEntity.ok("Player "+playerNumber+" WON");
        }
        return ResponseEntity.ok("Player "+playerNumber+" next position "+nextPosition);
    }
}
