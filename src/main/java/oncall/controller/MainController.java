package oncall.controller;

import oncall.model.Assignment;
import oncall.model.EmergencyWorker;
import oncall.model.MonthStartDay;
import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {
    public void execute() {
        MonthStartDay monthStartDay = new MonthStartDay();
        monthStartDay.setMonthStartDay(InputView.getValidatedMonthStartDay());
        monthStartDay.generateWeekdayList();

        EmergencyWorker emergencyWorker = new EmergencyWorker();
        emergencyWorker.setWeekdayEmergencyWorker(InputView.getValidatedWeekdayEmergencyWorker());
        emergencyWorker.setWeekendEmergencyWorker(InputView.getValidatedWeekendEmergencyWorker());

        Assignment assignment = new Assignment();
        assignment.assignInOrder();
        OutputView.printMonthlySchedule();
    }
}
