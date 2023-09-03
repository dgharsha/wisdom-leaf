package com.wisdomleaf.codetest.service;

import com.wisdomleaf.codetest.exception.InvalidTimeFormatException;
import org.springframework.stereotype.Service;

import static com.wisdomleaf.codetest.util.Constants.TIME_TO_STRING;

@Service
public class TimeConverter {

    public String convertTime(String time) throws InvalidTimeFormatException {
        validateTime(time);
        String[] timeSplit = time.split(":");
        int hours = Integer.parseInt(timeSplit[0]);
        int minutes = Integer.parseInt(timeSplit[1]);
        StringBuilder result = new StringBuilder("It's ");
        result.append(getHoursString(hours));
        result.append(" ");
        result.append(getMinutesString(minutes));
        result.append(" ");
        if(hours > 11) {
            result.append("PM");
        } else {
            result.append("AM");
        }
        return result.toString();
    }

    public String getMidDayOrMidNight(String time) throws InvalidTimeFormatException {
        validateTime(time);
        String[] timeSplit = time.split(":");
        int hours = Integer.parseInt(timeSplit[0]);
        String result;
        if(hours > 10 && hours < 16) {
            result = "It's Midday";
        } else if (hours == 23 || hours < 4) {
            result = "It's Midnight";
        } else if (hours > 18) {
            result = "It's already night";
        } else {
            result = "It's wonderful day";
        }
        return result;
    }

    private String getHoursString(int hours) {
        if(hours > 12) {
            hours -= 12;
        }
        return TIME_TO_STRING.get(hours);
    }

    private String getMinutesString(int minutes) {
        if(minutes > 20) {
            int lastDigit = minutes%10;
            return TIME_TO_STRING.get(minutes - lastDigit) + " " + TIME_TO_STRING.get(lastDigit);
        }else {
            return TIME_TO_STRING.get(minutes);
        }
    }

    private void validateTime(String time) throws InvalidTimeFormatException {
        if(time == null || time.isEmpty()) {
            throw new InvalidTimeFormatException("Time cannot be empty");
        }
        if(!time.contains(":") || time.indexOf(":") > time.lastIndexOf(":")) {
            throw new InvalidTimeFormatException("Time should be HH:MM format(24-hour format)");
        }
        String[] timeSplit = time.split(":");
        int hours;
        int minutes;
        try {
            hours = Integer.parseInt(timeSplit[0]);
            minutes = Integer.parseInt(timeSplit[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidTimeFormatException("Time should be HH:MM format(24-hour format) and HH & MM should be numbers");
        }
        if(hours < 0 || hours > 23) {
            throw new InvalidTimeFormatException("Hours should be in range 0 & 23");
        }
        if(minutes < 0 || minutes > 59) {
            throw new InvalidTimeFormatException("Minutes should be in range 0 and 59");
        }
    }
}
