package oncall.view;

import static oncall.util.ExceptionMessage.INVALID_INPUT;

import camp.nextstep.edu.missionutils.Console;
import oncall.util.Validator;

@FunctionalInterface
interface InputReader {
    String readInput();
}

@FunctionalInterface
interface ValidateReader {
    void validate(String userInput);
}

public class InputView {

    public static String getValidatedInput(InputReader inputReader, ValidateReader validateReader, String errorMessage) {
        String userInput;
        while (true) {
            try {
                userInput = inputReader.readInput();
                validateReader.validate(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }
        return userInput;
    }

    public static String readMonthStartDay() {
        OutputView.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public static String getValidatedMonthStartDay() {
        return getValidatedInput(InputView::readMonthStartDay, Validator::validateMonthStartDay, INVALID_INPUT.getMessage());
    }

    public static String readWeekdayEmergencyWorker() {
        OutputView.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

    public static String getValidatedWeekdayEmergencyWorker() {
        return getValidatedInput(InputView::readWeekdayEmergencyWorker, Validator::validateWeekdayEmergencyWorker,
                INVALID_INPUT.getMessage());
    }



//    public static String readWeekdayEmergencyWorker() {
//        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
//        return Console.readLine();
//    }
//
//    public static String getValidatedWeekdayEmergencyWorker() {
//        return getValidatedInput(InputView::readWeekdayEmergencyWorker, Validator::validateWeekdayEmergencyWorker,
//                INVALID_INPUT.getMessage());
//    }
}
