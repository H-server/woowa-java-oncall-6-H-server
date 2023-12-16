package oncall.view;

public class OutputView {
    public static void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printEnter() {
        System.out.println();
    }
}
