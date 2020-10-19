package com.mlawton.babysittercalculator;

import org.junit.Assert;
import org.junit.Test;

public class ShiftTest {

    @Test
    public void getTotalShiftDuration_WhenShiftStartsAtFiveAndEndsAtSix_ReturnsOneHour() {
        Shift testShift = new Shift("5:00 PM", "6:00 PM", "6:00 PM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(1, testShiftDuration);
    }

    @Test
    public void getTotalShiftDuration_WhenShiftStartsAtElevenAndEndsAtMidnight_ReturnsOneHour() {
        Shift testShift = new Shift("11:00 PM", "12:00 AM", "12:00 AM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(1, testShiftDuration);
    }

    @Test
    public void getTotalShiftDuration_WhenShiftStartsAtFiveAndEndsAtSixTewnty_ReturnsTwoHours() {
        Shift testShift = new Shift("5:00 PM", "6:20 PM", "6:20 PM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(2, testShiftDuration);
    }

    @Test
    public void getTotalShiftDuration_WhenShiftStartsAtFiveTwentyAndEndsAtSeven_ReturnsTwoHours() {
        Shift testShift = new Shift("5:20 PM", "7:00 PM", "7:00 PM");
        long testShiftDuration = testShift.getTotalShiftDuration();
        Assert.assertEquals(2, testShiftDuration);
    }

    @Test
    public void getLateShiftDuration_WhenShiftStartsAtMidnightAndEndsAtOne_ReturnsOneHour() {
        Shift testShift = new Shift("12:00 AM", "1:00 AM", "1:00 AM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(1, testLateShiftDuration);
    }

    @Test
    public void getLateShiftDuration_ShiftStartsAtElevenAndEndsAtOne_ReturnsOneHour() {
        Shift testShift = new Shift("11:00 PM", "1:00 AM", "1:00 AM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(1, testLateShiftDuration);
    }

    @Test
    public void getLateShiftDuration_ShiftStartsAtTenAndEndsAtEleven_ReturnsZeroHours() {
        Shift testShift = new Shift("10:00 PM", "11:00 PM", "11:00 PM");
        long testLateShiftDuration = testShift.getLateShiftDuration();
        Assert.assertEquals(0, testLateShiftDuration);
    }

    @Test
    public void getSleepShiftDuration_WhenBedTimeIsTenAndEndTimeIsEleven_ReturnsOneHour() {
        Shift testShift = new Shift("10:00 PM", "10:00 PM", "11:00 PM");
        long testSleepShiftDuration = testShift.getSleepShiftDuration();
        Assert.assertEquals(1, testSleepShiftDuration);
    }

    @Test
    public void getSleepShiftDuration_WhenBedTimeIsElevenAndEndTimeIsEleven_ReturnsZeroHours() {
        Shift testShift = new Shift("10:00 PM", "11:00 PM", "11:00 PM");
        long testSleepShiftDuration = testShift.getSleepShiftDuration();
        Assert.assertEquals(0, testSleepShiftDuration);
    }

    @Test
    public void getSleepShiftDuration_WhenBedTimeIsTenAndEndTimeIsOne_ReturnsTwoHours() {
        Shift testShift = new Shift("10:00 PM", "10:00 PM", "1:00 AM");
        long testSleepShiftDuration = testShift.getSleepShiftDuration();
        Assert.assertEquals(2, testSleepShiftDuration);
    }

    @Test
    public void getDayShiftDuration_WhenStartTimeIsFiveAndBedTimeIsEight_ReturnsThreeHours() {
        Shift testShift = new Shift("5:00 PM", "8:00 PM", "1:00 AM");
        long testDayShiftDuration = testShift.getDayShiftDuration();
        Assert.assertEquals(3, testDayShiftDuration);
    }

    @Test
    public void getDayShiftDuration_WhenStartTimeIsFiveAndEndTimeIsOneAndNoBedTime_ReturnsSevenHours() {
        Shift testShift = new Shift("5:00 PM", "1:00 AM", "1:00 AM");
        long testDayShiftDuration = testShift.getDayShiftDuration();
        Assert.assertEquals(7, testDayShiftDuration);
    }

    @Test
    public void getDayShiftDuration_WhenStartTimeIsFiveAndEndTimeIsEightAndNoBedTime_ReturnsThreeHours() {
        Shift testShift = new Shift("5:00 PM", "8:00 PM", "8:00 PM");
        long testDayShiftDuration = testShift.getDayShiftDuration();
        Assert.assertEquals(3, testDayShiftDuration);
    }

    @Test
    public void getDayShiftDuration_WhenStartTimeIsTenAndBedTimeTen_ReturnsZeroHours() {
        Shift testShift = new Shift("10:00 PM", "10:00 PM", "11:00 PM");
        long testDayShiftDuration = testShift.getDayShiftDuration();
        Assert.assertEquals(0, testDayShiftDuration);
    }

}
