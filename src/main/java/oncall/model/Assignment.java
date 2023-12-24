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

    private void assignWeekdayEmergencyWorker() { // 이게 있으니까 나눴다고 생각한 듯.
        String worker = EmergencyWorker.getWeekdayEmergencyWorker();
        handleConsecutiveWork(worker);
    }

    private void assignWeekendEmergencyWorker() {
        String worker = EmergencyWorker.getWeekendEmergencyWorker();
        handleConsecutiveWork(worker);
    }

    private void handleConsecutiveWork(String worker) {
        if (!assignmentResult.isEmpty() && assignmentResult.get(assignmentResult.size() - 1).equals(worker)) {
            worker = specialCase(worker); // 이게 위에 있었어야 해!! 일반적인 경우는 day를 건들잖아!! 순서의 중요성(평일, 휴일 이렇게 해선 안돼)
            // 정말 코딩은 사소한 걸로 갈린다. 디테일...
            if(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1)) {
                generalCase();
            }
        }
        assignmentResult.add(worker);
    }

    private void generalCase() {
        if(MonthStartDay.getIsWeekday(day)) { // 실전에서 이 경우를 빠뜨림
            String nextWorker = EmergencyWorker.getWeekdayEmergencyWorker();
            assignmentResult.add(nextWorker);
            day++;
            EmergencyWorker.plusWeekdayWorkerCount();
        }
         if(!MonthStartDay.getIsWeekday(day)) {
            String nextWorker = EmergencyWorker.getWeekendEmergencyWorker();
            assignmentResult.add(nextWorker);
            day++;
            EmergencyWorker.plusWeekendWorkerCount();
        }
    }

    private String specialCase(String worker) {
        if(!(MonthStartDay.getIsWeekday(day) == MonthStartDay.getIsWeekday(day+1))) {
            if(!MonthStartDay.getIsWeekday(day)) { // 휴일
                String nextWeekendWorker = EmergencyWorker.getWeekendEmergencyWorker();
                EmergencyWorker.changeWeekendWorker(worker, nextWeekendWorker);
                worker = EmergencyWorker.getWeekendEmergencyWorker();
            }
            if(MonthStartDay.getIsWeekday(day)) { // 평일 이 경우를 리팩토링해야함
                String nextWeekdayWorker = EmergencyWorker.getWeekdayEmergencyWorker();
                EmergencyWorker.changeWeekdayWorker(worker, nextWeekdayWorker);
                worker = EmergencyWorker.getWeekdayEmergencyWorker();
            }
        }
        return worker;
    }

    public List<String> getAssignmentResult() {
        return assignmentResult;
    }
}
