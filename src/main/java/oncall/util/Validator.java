package oncall.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static Set<String> weekdayEmergencyWorkers = new HashSet<>();
    private static Set<String> weekendEmergencyWorkers = new HashSet<>();

    public static void validateMonthStartDay(String input) {
        String[] inputParts = splitInput(input);
        validateLength(inputParts);
        int month = validateMonth(inputParts[0]);
        String startDay = validateStartDay(inputParts[1]);

    }

    private static String[] splitInput(String input) {
        String[] inputParts = input.split(",");
        return inputParts;
    }

    private static void validateLength(String[] inputParts) {
        if (inputParts.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateMonth(String monthStr) {
        try {
            int month = Integer.parseInt(monthStr.trim());
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException();
            }
            return month;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String validateStartDay(String startDayStr) {
        String startDay = startDayStr.trim();
        List<String> validDays = Arrays.asList("일", "월", "화", "수", "목", "금", "토");
        if (!validDays.contains(startDay)) {
            throw new IllegalArgumentException();
        }
        return startDay;
    }

    public static void validateWeekdayEmergencyWorker(String input) {
        String[] workers = splitInput(input);
        validateTotalWorkers(workers);

        Set<String> workerSet = new HashSet<>();

        for (String worker : workers) {
            validateWorkerNickname(worker);
            checkDuplicateWorker(worker, workerSet);
        }
        weekdayEmergencyWorkers = workerSet;
    }

    private static void validateTotalWorkers(String[] workers) {
        if (workers.length < 5 || workers.length > 35) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWorkerNickname(String worker) {
        if (worker.trim().length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicateWorker(String worker, Set<String> workerSet) {
        if (!workerSet.add(worker.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWeekendEmergencyWorker(String input) {
        String[] workers = splitInput(input);
        validateTotalWorkers(workers);
        Set<String> workerSet = new HashSet<>();
        for (String worker : workers) {
            validateWorkerNickname(worker);
            checkDuplicateWorker(worker, workerSet);
        }
        weekendEmergencyWorkers = workerSet;
        validateWorkerListsConsistency();
    }

    private static void validateWorkerListsConsistency() {
        if (!(weekdayEmergencyWorkers.equals(weekendEmergencyWorkers))) {
            throw new IllegalArgumentException();
        }
    }
}
