package oncall.model;

import static org.junit.jupiter.api.Assertions.*;

import oncall.view.InputView;
import oncall.view.OutputView;
import org.junit.jupiter.api.Test;

class AssignmentTest {
    @Test
    void 휴일_평일_휴일인_경우() {
        String output = "5월 1일 금 준팍\n5월 2일 토 고니\n5월 3일 일 루루\n5월 4일 월 수아\n5월 5일 화(휴일) 솔로스타\n5월 6일 수 도밥\n5월 7일 목 고니\n5월 8일 금 루루\n5월 9일 토 수아\n5월 10일 일 우코";

        MonthStartDay monthStartDay = new MonthStartDay();
        monthStartDay.setMonthStartDay("5,금");
        monthStartDay.generateWeekdayList();

        EmergencyWorker emergencyWorker = new EmergencyWorker();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,수아,도밥,고니,루루,글로,솔로스타,우코,슬링키,참새,도리");
        emergencyWorker.setWeekendEmergencyWorker("고니,루루,수아,솔로스타,우코,슬링키,참새,글로,준팍,도밥,도리");

        Assignment assignment = new Assignment();
        assignment.assignInOrder();
        OutputView.printMonthlySchedule();
    }

    @Test
    void 평일_휴일_평일인_경우() {
        MonthStartDay monthStartDay = new MonthStartDay();
        monthStartDay.setMonthStartDay("5,금");
        monthStartDay.generateWeekdayList();

        EmergencyWorker emergencyWorker = new EmergencyWorker();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,수아,솔로스타,고니,루루,글로,도밥,우코,슬링키,참새,도리");
        emergencyWorker.setWeekendEmergencyWorker("고니,루루,솔로스타,수아,우코,슬링키,참새,글로,준팍,도밥,도리");

        Assignment assignment = new Assignment();
        assignment.assignInOrder();
        OutputView.printMonthlySchedule();
    }

}