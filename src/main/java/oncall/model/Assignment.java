package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private static List<String> assignmentResult = new ArrayList<>();
    private static int day = 1;

    public void assignInOrder() {
        while(day <= MonthStartDay.getDaysInMonth()) {
            if(MonthStartDay.getIsWeekday(day)) {
                assignWeekdayEmergencyWorker();
            }
            if(!MonthStartDay.getIsWeekday(day)) {
                assignWeekendEmergencyWorker();
            }
            day++;
        }
    }

    private void assignWeekdayEmergencyWorker() {
        String worker = EmergencyWorker.getWeekdayEmergencyWorker();
        handleConsecutiveWork(worker);
    }

    private void assignWeekendEmergencyWorker() {
        String worker = EmergencyWorker.getWeekendEmergencyWorker();
        handleConsecutiveWork(worker);
    }

    private void handleConsecutiveWork(String worker) {
        if (!assignmentResult.isEmpty() && assignmentResult.get(assignmentResult.size() - 1).equals(worker)) {
            worker = generalCase(worker);
            worker = specialCase(worker);
        }
        assignmentResult.add(worker);
    }

    private String generalCase(String worker) {
        if(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1)) {
            String nextWorker = EmergencyWorker.getWeekendEmergencyWorker();
            assignmentResult.add(nextWorker);
            day++;
            EmergencyWorker.plusWeekendWorkerCount();
        }
        return worker;
    }

    private String specialCase(String worker) {
        if(!(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1))) {
            if(!MonthStartDay.getIsWeekday(day)) {
                String nextWeekendWorker = EmergencyWorker.getWeekendEmergencyWorker();
                EmergencyWorker.changeWeekendWorker(worker, nextWeekendWorker);
                worker = EmergencyWorker.getWeekendEmergencyWorker();
            }
            if(MonthStartDay.getIsWeekday(day)) {
                String nextWeekdayWorker = EmergencyWorker.getWeekdayEmergencyWorker();
                EmergencyWorker.changeWeekdayWorker(worker, nextWeekdayWorker);
                worker = EmergencyWorker.getWeekdayEmergencyWorker();
            }
        }
        return worker;
    }

    public static List<String> getAssignmentResult() {
        return assignmentResult;
    }
}
