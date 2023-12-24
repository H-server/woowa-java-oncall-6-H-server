package oncall.view;

import java.util.List;
import oncall.model.Assignment;
import oncall.model.MonthStartDay;

public class OutputView {

    public static String printMonthlySchedule() {
        Assignment assignment = new Assignment();
        int month = MonthStartDay.getMonth();
        int daysInMonth = MonthStartDay.getDaysInMonth();
        List<String> weekDays = MonthStartDay.getWeekDays();
        List<String> assignmentResult = assignment.getAssignmentResult();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= daysInMonth; i++) {
            String dayString = month + "월 " + i + "일 " + weekDays.get((i - 1) % 7);
            output = new StringBuilder(dayString);
            if (MonthStartDay.getIsWeekdayExceptHoliday(i) && MonthStartDay.isHoliday(i)) {
                output.append("(휴일)");
            }
            output.append(" " + assignmentResult.get(i - 1));
            println(output.toString());
        }
        return output.toString();
    }

    public static void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printEnter() {
        System.out.println();
    }

}
