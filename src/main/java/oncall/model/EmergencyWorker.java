package oncall.model;

import static oncall.util.Util.splitByComma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmergencyWorker {
    private static List<String> originalWeekdayEmergencyWorker;
    private static List<String> originalWeekendEmergencyWorker;
    private static List<String> weekdayEmergencyWorker;
    private static List<String> weekendEmergencyWorker;
    private static int weekdayWorkerCount = -1;
    private static int weekendWorkerCount = -1;

    public void setWeekdayEmergencyWorker(String input) {
        weekdayEmergencyWorker = Arrays.asList(splitByComma(input));
        originalWeekdayEmergencyWorker = weekdayEmergencyWorker;
    }

    public void setWeekendEmergencyWorker(String input) {
        weekendEmergencyWorker = Arrays.asList(splitByComma(input));
        originalWeekendEmergencyWorker = weekendEmergencyWorker;
    }

    public static String getWeekdayEmergencyWorker() {
        weekdayWorkerCount++;
        if(weekdayWorkerCount % weekdayEmergencyWorker.size() == 0) {
            weekdayEmergencyWorker = originalWeekdayEmergencyWorker;
        }
        return weekdayEmergencyWorker.get(weekdayWorkerCount % weekdayEmergencyWorker.size());
    }

    public static String getWeekendEmergencyWorker() {
        weekendWorkerCount++;
        if(weekendWorkerCount % weekendEmergencyWorker.size() == 0) {
            weekendEmergencyWorker = originalWeekendEmergencyWorker;
        }
        return weekendEmergencyWorker.get(weekendWorkerCount % weekendEmergencyWorker.size());
    }

    public static void changeWeekdayWorker(String i, String j) {
        Collections.swap(weekdayEmergencyWorker, weekdayEmergencyWorker.indexOf(i), weekdayEmergencyWorker.indexOf(j));
        //이거 떄문인듯 day와 end를 혼동함. 실전에서의 실수. 와 이것도 한끝차이로 틀렸네...
        minusWeekdayWorkerCount();
        minusWeekdayWorkerCount();
    }

    public static void changeWeekendWorker(String i, String j) {
        Collections.swap(weekendEmergencyWorker, weekendEmergencyWorker.indexOf(i), weekendEmergencyWorker.indexOf(j));
        minusWeekendWorkerCount();
        minusWeekendWorkerCount();
    }

    public static void plusWeekendWorkerCount() {
        weekendWorkerCount++;
    }

    public static void plusWeekdayWorkerCount() {
        weekdayWorkerCount++;
    }

    public static void minusWeekendWorkerCount() {
        weekendWorkerCount--;
    }

    public static void minusWeekdayWorkerCount() {
        weekdayWorkerCount--;
    }
}
