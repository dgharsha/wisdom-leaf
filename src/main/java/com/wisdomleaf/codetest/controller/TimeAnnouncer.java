package com.wisdomleaf.codetest.controller;

import com.wisdomleaf.codetest.exception.InvalidTimeFormatException;
import com.wisdomleaf.codetest.service.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/announce")
public class TimeAnnouncer {

    @Autowired
    TimeConverter timeConverter;

    @GetMapping("/time/{time}")
    public String announceTime(@PathVariable("time") String time) throws InvalidTimeFormatException {
        return timeConverter.convertTime(time);
    }

    @GetMapping("/middayornight/{time}")
    public String announceMidDayOrMidNight(@PathVariable("time") String time) throws InvalidTimeFormatException {
        return timeConverter.getMidDayOrMidNight(time);
    }
}
