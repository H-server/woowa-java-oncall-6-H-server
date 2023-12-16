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
            if(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1)) {
                String nextWorker = EmergencyWorker.getWeekendEmergencyWorker();
                assignmentResult.add(nextWorker);
                day++;
                EmergencyWorker.plusWeekendWorkerCount();
                // 일반적인 경우 -> 순서 바꿔서 저장
            }
//            if(!(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1))) {
//                // 특수한 경우 -> 그 해당하는 리스트에서 다음 근무자랑 변경 후 저장
//            }
        }
        assignmentResult.add(worker);
    }

    public static List<String> getAssignmentResult() {
        return assignmentResult;
    }
}
