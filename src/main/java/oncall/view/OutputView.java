package oncall.view;

import java.util.List;
import oncall.model.Assignment;
import oncall.model.MonthStartDay;

public class OutputView {

    public static void printMonthlySchedule() {
        int month = MonthStartDay.getMonth();
        int daysInMonth = MonthStartDay.getDaysInMonth();
        List<String> weekDays = MonthStartDay.getWeekDays();
        List<String> assignmentResult = Assignment.getAssignmentResult();
        for(int i=1; i<=daysInMonth; i++) {
            println(month + "월" + " " + i + "일" + " " + weekDays.get((i-1)%7) + " " + assignmentResult.get(i-1));
        }
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
