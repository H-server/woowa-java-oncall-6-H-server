package oncall.util;

public enum ExceptionMessage {
    INVALID_MONTH_START_DAY("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
