package com.example.boardgame.backend.controller;

import com.example.boardgame.backend.model.Meeting;
import com.example.boardgame.backend.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

   @PostMapping("/create")
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting){
       Meeting savedMeeting = meetingService.createMeeting(meeting);
       return new ResponseEntity<Meeting>(savedMeeting,HttpStatus.CREATED);
   }

   @GetMapping("/getMeetings")
    public ResponseEntity<List<Meeting>> getAllMeetings(){
       List<Meeting> allMeetings = meetingService.getAllMeetings();
       return new ResponseEntity<>(allMeetings, HttpStatus.OK);
   }
}
