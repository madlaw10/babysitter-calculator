package com.mlawton.babysittercalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Shift {
    final private LocalTime startTime;
    final private LocalTime bedTime;
    final private LocalTime endTime;

    public Shift(String startTime, String bedTime, String endTime) {
        this.startTime = formatAndRoundUpTime(startTime);
        this.bedTime = formatAndRoundUpTime(bedTime);
        this.endTime = formatAndRoundUpTime(endTime);
    }

    public long getTotalShiftDuration () {
        return getDuration(this.startTime, this.endTime);
    }

    private long getDuration (LocalTime shiftStart, LocalTime shiftEnd) {
        long duration = shiftStart.until(shiftEnd, ChronoUnit.HOURS);
        if (duration > 0) {
            return duration;
        }

        LocalDateTime adjustedShiftStart = LocalDateTime.of(LocalDate.now(), shiftStart);
        LocalDateTime adjustedShiftEnd = LocalDateTime.of(LocalDate.now().plusDays(1), shiftEnd);
        long adjustedDuration = adjustedShiftStart.until(adjustedShiftEnd, ChronoUnit.HOURS);

        return adjustedDuration;
    }

    private LocalTime formatAndRoundUpTime(String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime formattedTime = LocalTime.parse(time, format);

        if (formattedTime.getMinute() == 0) {
            return formattedTime;
        }

        return formattedTime.plusMinutes(60 - formattedTime.getMinute());
    }

}
