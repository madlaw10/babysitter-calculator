package com.mlawton.babysittercalculator;

import org.junit.Assert;
import org.junit.Test;

public class ShiftTest {

    @Test
    public void shouldComputeTotalShiftHoursAsOneHourIfShiftStartsAtFiveAndEndsAtSix() {
        Shift testShift = new Shift("5:00 PM", "6:00 PM", "6:00 PM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(1, testShiftDuration);
    }

    @Test
    public void shouldComputeTotalShiftHoursAsOneHourIfShiftStartsAtElevenAndEndsAtMidnight() {
        Shift testShift = new Shift("11:00 PM", "12:00 AM", "12:00 AM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(1, testShiftDuration);
    }

    @Test
    public void shouldComputeTotalShiftHoursAsTwoHoursIfShiftStartsAtFiveAndEndsAtSixThirty() {
        Shift testShift = new Shift("5:00 PM", "6:30 PM", "6:30 PM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(2, testShiftDuration);
    }

    @Test
    public void shouldComputeLateShiftHoursAsOneHourIfShiftStartsAtMidnightAndEndsAtOne() {
        Shift testShift = new Shift("12:00 AM", "1:00 AM", "1:00 AM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(1, testLateShiftDuration);
    }

    @Test
    public void shouldComputeLateShiftHoursAsOneHourIfShiftStartsAtElevenAndEndsAtOne() {
        Shift testShift = new Shift("11:00 PM", "1:00 AM", "1:00 AM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(1, testLateShiftDuration);
    }

    @Test
    public void shouldComputeLateShiftHoursAsZeroHourIfShiftStartsAtElevenAndEndsAtMidnight() {
        Shift testShift = new Shift("11:00 PM", "12:00 AM", "12:00 AM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(0, testLateShiftDuration);
    }

}
