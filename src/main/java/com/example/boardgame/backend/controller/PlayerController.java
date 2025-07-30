package com.example.boardgame.backend.controller;

import com.example.boardgame.backend.model.Player;
import com.example.boardgame.backend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player savedPlayer = playerService.createPlayer(player);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
