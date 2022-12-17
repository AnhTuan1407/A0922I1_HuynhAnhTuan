package Lession4_Class_Object;

import java.time.LocalTime;
import java.util.Scanner;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalTime getStartTime(LocalTime startTime) {
        return startTime;
    }

    public LocalTime getEndTime(LocalTime endTime) {
        return endTime;
    }

    public StopWatch() {
        this.startTime = LocalTime.now();
    }

    public void start() {
        this.startTime = LocalTime.now();
        getStartTime(startTime);
    }

    public void stop() {
        this.endTime = LocalTime.now();
        getEndTime(endTime);
    }

    public void getElapsedTime() {
        int ElaspedTime = (endTime.toSecondOfDay() - startTime.toSecondOfDay()) * 100;
        System.out.println("MiliSecond: " + ElaspedTime);
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Counting time...");
        for (int i = 1; 1 <= 100; i++) {
            stopWatch.stop();
            stopWatch.getElapsedTime();
        }
    }
}
