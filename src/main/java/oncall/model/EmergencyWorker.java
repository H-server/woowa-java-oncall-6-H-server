package oncall.model;

import static oncall.util.Util.splitByComma;

import java.util.Arrays;
import java.util.List;

public class EmergencyWorker {
    private static List<String> weekdayEmergencyWorker;
    private static List<String> weekendEmergencyWorker;

    public void setWeekdayEmergencyWorker(String input) {
        weekdayEmergencyWorker = Arrays.asList(splitByComma(input));
    }

    public void setWeekendEmergencyWorker(String input) {
        weekendEmergencyWorker = Arrays.asList(splitByComma(input));
    }

    public static String getWeekdayEmergencyWorker(int day) {
        return weekdayEmergencyWorker.get(day % weekdayEmergencyWorker.size() - 1);
    }

    public static String getWeekendEmergencyWorker(int day) {
        return weekendEmergencyWorker.get(day % weekendEmergencyWorker.size() - 1);
    }
}
