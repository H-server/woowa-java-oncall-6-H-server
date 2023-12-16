package oncall.util;

import java.util.Arrays;
import java.util.List;

public class Validator {

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
}
