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

}
