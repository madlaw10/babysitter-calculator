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

    public long getLateShiftDuration () {
        if (this.endTime.compareTo(LocalTime.MIDNIGHT) == 0 ||
            this.endTime.compareTo(LocalTime.NOON) > 0) {
            return 0;
        }
        return getDuration(LocalTime.MIDNIGHT, this.endTime);
    }

    public long getSleepShiftDuration () {
        if (this.bedTime.compareTo(LocalTime.MIDNIGHT) == 0 ||
            this.bedTime.compareTo(this.endTime) == 0) {
            return 0;
        }
        if (this.endTime.compareTo(LocalTime.NOON) < 0) {
            return getDuration(this.bedTime, LocalTime.MIDNIGHT);
        }
        return getDuration(this.bedTime, this.endTime);
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
