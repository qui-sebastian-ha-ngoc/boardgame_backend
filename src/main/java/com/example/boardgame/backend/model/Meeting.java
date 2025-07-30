package com.example.boardgame.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String dateTime;
    private String location;
    private String description;
    private String host;
    private String games;
    @ElementCollection
    @CollectionTable(name = "entity_votes", joinColumns = @JoinColumn(name = "entity_id"))
    @MapKeyColumn(name = "game_name")
    @Column(name = "vote_count")
    private Map<String, Integer> votes;
    private Set<String> allGames;
}
