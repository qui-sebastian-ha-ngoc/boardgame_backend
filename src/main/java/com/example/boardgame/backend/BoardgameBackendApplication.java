package com.example.boardgame.backend;

import com.example.boardgame.backend.model.Meeting;
import com.example.boardgame.backend.model.Player;
import com.example.boardgame.backend.repo.MeetingRepo;
import com.example.boardgame.backend.repo.PlayerRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class BoardgameBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgameBackendApplication.class, args);
	}

	@Autowired
	private MeetingRepo meetingRepo;

	@Autowired
	private PlayerRepo playerRepo;
	@PostConstruct
	public void init() {
		Meeting meeting = new Meeting();
		meeting.setTitle("Boardgame Abend");
		meeting.setDateTime("2025-08-15T19:00");
		meeting.setLocation("Berlin");
		meeting.setDescription("Wir spielen Brettspiele!");
		meeting.setHost("John");

		Map<String, Integer> votes = new HashMap<>();
		votes.put("Catan", 4);
		votes.put("Azul", 2);
		meeting.setVotes(votes);

		meeting.setGames("Catan, Azul");
		meeting.setAllGames(Set.of("Catan", "Azul", "Codenames"));

		meetingRepo.save(meeting);

		Meeting meeting2 = new Meeting();
		meeting2.setTitle("Trinkspiel Abend");
		meeting2.setDateTime("2025-08-30T20:00");
		meeting2.setLocation("Hamburg");
		meeting2.setDescription("Wir spielen Trinkspiele!");
		meeting2.setHost("Kai");

		Map<String, Integer> votes2 = new HashMap<>();
		votes2.put("Bier Pong", 3);
		votes2.put("Kings Cup", 2);
		votes2.put("Busfahrer", 1);
		meeting2.setVotes(votes);

		meeting2.setGames("Bier Pong, Kings Cup, Busfahrer");
		meeting2.setAllGames(Set.of("Bier Pong", "Kings Cup", "Busfahrer"));

		meetingRepo.save(meeting2);

		Meeting meeting3 = new Meeting();
		meeting3.setTitle("Sport Abend");
		meeting3.setDateTime("2025-12-10T19:00");
		meeting3.setLocation("München");
		meeting3.setDescription("Wir machen Sport");
		meeting3.setHost("Qui");

		Map<String, Integer> votes3 = new HashMap<>();
		votes3.put("Soccerhalle", 1);
		votes3.put("Bowling", 1);
		meeting.setVotes(votes3);

		meeting3.setGames("Soccerhalle, Bowling");
		meeting3.setAllGames(Set.of("Soccerhalle", "Bowling"));

		meetingRepo.save(meeting3);

		Player player1 = new Player();
		player1.setName("John");

		playerRepo.save(player1);

		Player player2 = new Player();
		player2.setName("Qui");

		playerRepo.save(player2);

		Player player3 = new Player();
		player3.setName("Kai");

		playerRepo.save(player3);
	}

}
