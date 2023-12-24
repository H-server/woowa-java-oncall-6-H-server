package oncall.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssignmentTest {


    // 테스트끼리 의존하는 경우 해결
    @Test
    void 일반적인_경우_평일_휴일_휴일() {
        MonthStartDay monthStartDay = new MonthStartDay();
        EmergencyWorker emergencyWorker = new EmergencyWorker();
        Assignment assignment = new Assignment();
        List<String> workerActualList = Arrays.asList("준팍", "도밥", "고니", "수아", "루루", "수아");
        monthStartDay.setMonthStartDay("5,월");
        monthStartDay.generateWeekdayList();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        emergencyWorker.setWeekendEmergencyWorker("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");

        assignment.assignInOrder();
        assertEquals(assignment.getAssignmentResult().subList(0, 6), workerActualList);
    }

    @Test
    void 일반적인_경우_휴일_평일_평일() {
        MonthStartDay monthStartDay = new MonthStartDay();
        EmergencyWorker emergencyWorker = new EmergencyWorker();
        Assignment assignment = new Assignment();
        List<String> workerActualList = Arrays.asList("준팍", "도밥", "수아", "루루", "수아", "루루", "글로");
        monthStartDay.setMonthStartDay("10,월");
        monthStartDay.generateWeekdayList();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,도밥,수아,루루,글로,솔로스타,우코,슬링키,참새,도리,고니");
        emergencyWorker.setWeekendEmergencyWorker("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");

        assignment.assignInOrder();
        assertEquals(assignment.getAssignmentResult().subList(0, 7), workerActualList);
    }

    @Test
    void 특수한_경우_평일_휴일_평일인_경우() {
        MonthStartDay monthStartDay = new MonthStartDay();
        EmergencyWorker emergencyWorker = new EmergencyWorker();
        Assignment assignment = new Assignment();
        List<String> workerActualList = Arrays.asList("준팍", "고니", "루루", "도밥", "수아", "고니", "글로");
        monthStartDay.setMonthStartDay("10,월");
        monthStartDay.generateWeekdayList();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,고니,도밥,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        emergencyWorker.setWeekendEmergencyWorker("고니,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,수아");

        assignment.assignInOrder();
        assertEquals(assignment.getAssignmentResult().subList(0, 7), workerActualList);
    }

    @Test
    void 특수한_경우_휴일_평일_휴일인_경우() {
        MonthStartDay monthStartDay = new MonthStartDay();
        EmergencyWorker emergencyWorker = new EmergencyWorker();
        Assignment assignment = new Assignment();
        List<String> workerActualList = Arrays.asList("고니", "준팍", "수아", "솔로스타", "도리", "루루", "솔로스타", "수아", "도리", "글로");
        monthStartDay.setMonthStartDay("5,일");
        monthStartDay.generateWeekdayList();
        emergencyWorker.setWeekdayEmergencyWorker("준팍,수아,솔로스타,도리,루루,글로,도밥,우코,슬링키,참새,고니");
        emergencyWorker.setWeekendEmergencyWorker("고니,도리,솔로스타,수아,우코,슬링키,참새,글로,준팍,도밥,루루");

        assignment.assignInOrder();
        assertEquals(assignment.getAssignmentResult().subList(0, 10), workerActualList);
    }

    // 테스트 케이스 먼저
    // 1. 일반적인 경우 1
    // 2. 일반적인 경우 2
    // 3. 특수한 경우 휴평휴
    // 4. 특수한 경우 평휴평
    // 짜잘한 유틸
    // 그런데 나는 큰 단위의 테스트가 아니라 "준팍, 고니, 루루" 이렇게 입력하면서 테스트하고 싶어.
}