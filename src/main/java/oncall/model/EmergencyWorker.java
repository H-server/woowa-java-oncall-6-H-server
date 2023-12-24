package oncall.model;

import static oncall.util.Util.splitByComma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmergencyWorker {
    private static List<String> weekdayEmergencyWorker;
    private static List<String> weekendEmergencyWorker;
    private static int weekdayWorkerCount = -1;
    private static int weekendWorkerCount = -1;

    public void setWeekdayEmergencyWorker(String input) {
        weekdayEmergencyWorker = Arrays.asList(splitByComma(input));
    }

    public void setWeekendEmergencyWorker(String input) {
        weekendEmergencyWorker = Arrays.asList(splitByComma(input));
    }

    public static String getWeekdayEmergencyWorker() {
        weekdayWorkerCount++;
        return weekdayEmergencyWorker.get(weekdayWorkerCount % weekdayEmergencyWorker.size());
    }

    public static String getWeekendEmergencyWorker() {
        weekendWorkerCount++;
        return weekendEmergencyWorker.get(weekendWorkerCount % weekendEmergencyWorker.size());
    }

    public static void changeWeekdayWorker(String i, String j) {
        Collections.swap(weekdayEmergencyWorker, weekdayEmergencyWorker.indexOf(i), weekdayEmergencyWorker.indexOf(j));
        minusWeekendWorkerCount(); //이거 떄문인듯
        minusWeekendWorkerCount();
    }

    public static void changeWeekendWorker(String i, String j) {
        Collections.swap(weekendEmergencyWorker, weekendEmergencyWorker.indexOf(i), weekendEmergencyWorker.indexOf(j));
        minusWeekdayWorkerCount();
        minusWeekdayWorkerCount();
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
        weekendWorkerCount--;
    }
}
