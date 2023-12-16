package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private static List<String> assignmentResult = new ArrayList<>();

    public void assignInOrder() {
        for(int day = 1; day <= MonthStartDay.getDaysInMonth(); day++) {
            if(MonthStartDay.getIsWeekday(day)) {
                assignmentResult.add(EmergencyWorker.getWeekdayEmergencyWorker());
            }
            if(!MonthStartDay.getIsWeekday(day)) {
                assignmentResult.add(EmergencyWorker.getWeekendEmergencyWorker());
            }
        }
        System.out.println(assignmentResult);
        System.out.println(assignmentResult.size());
    }
}
