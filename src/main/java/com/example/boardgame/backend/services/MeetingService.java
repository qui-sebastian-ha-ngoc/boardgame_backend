package com.example.boardgame.backend.services;

import com.example.boardgame.backend.model.Meeting;
import com.example.boardgame.backend.repo.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepo meetingRepo;

    public Meeting createMeeting(Meeting meeting){
        return meetingRepo.save(meeting);
    }

    public List<Meeting> getAllMeetings(){
        return meetingRepo.findAll();
    }
}
