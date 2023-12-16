package oncall.model;

import static oncall.util.Util.splitByComma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthStartDay {
    private static int month;
    private static String startDay;
    private static List<String> weekdays;
    private static Map<Integer, Integer> daysInMonth = new HashMap<>();
    private static Map<String, String> holidays = new HashMap<>();

    static {
        daysInMonth.put(1, 31); // 1월
        daysInMonth.put(2, 28); // 2월 (평년)
        daysInMonth.put(3, 31); // 3월
        daysInMonth.put(4, 30); // 4월
        daysInMonth.put(5, 31); // 5월
        daysInMonth.put(6, 30); // 6월
        daysInMonth.put(7, 31); // 7월
        daysInMonth.put(8, 31); // 8월
        daysInMonth.put(9, 30); // 9월
        daysInMonth.put(10, 31); // 10월
        daysInMonth.put(11, 30); // 11월
        daysInMonth.put(12, 31); // 12월
    }

    static {
        holidays.put("1-1", "신정");
        holidays.put("3-1", "삼일절");
        holidays.put("5-5", "어린이날");
        holidays.put("6-6", "현충일");
        holidays.put("8-15", "광복절");
        holidays.put("10-3", "개천절");
        holidays.put("10-9", "한글날");
        holidays.put("12-25", "성탄절");
    }

    public static boolean isHoliday(String day) {
        return holidays.containsKey(day);
    }

    public void setMonthStartDay(String input) {
        String[] monthStartDay = splitByComma(input);
        month = Integer.parseInt(monthStartDay[0]);
        startDay = monthStartDay[1];
    }

    public static int getDaysInMonth() {
        return daysInMonth.get(month);
    }

    public void generateWeekdayList() {
        weekdays = new ArrayList<>(Arrays.asList("월", "화", "수", "목", "금", "토", "일"));

        if (!startDay.equals("월")) {
            while (!weekdays.get(0).equals(startDay)) {
                String day = weekdays.remove(0);
                weekdays.add(day);
            }
        }
    }

    public static boolean getIsWeekday(int day) {
        if(isHoliday(day)) {
            return false;
        }
        return !(weekdays.get(day % 7).equals("토") || weekdays.get(day % 7).equals("일"));
    }

    public static boolean isHoliday(int day) {
        String key = String.format("%d-%d", month, day);
        return holidays.containsKey(key);
    }

    public static int getMonth() {
        return month;
    }

    public static List<String> getWeekDays() {
        return weekdays;
    }
}
