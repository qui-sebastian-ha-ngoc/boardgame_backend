package com.example.boardgame.backend.services;

import com.example.boardgame.backend.model.Player;
import com.example.boardgame.backend.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public Player createPlayer(Player player){
        return playerRepo.save(player);
    }

    public List<Player> getPlayers(){
        return playerRepo.findAll();
    }
}
