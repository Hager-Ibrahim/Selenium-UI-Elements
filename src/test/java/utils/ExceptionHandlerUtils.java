package utils;

public class ExceptionHandlerUtils {

    public static void handleInMinimizedAndMaximizedModes(Runnable doIfMinimizedMode, Runnable doIfMaximizedMode) {
        try {
            doIfMinimizedMode.run();
        } catch (Exception e) {
            doIfMaximizedMode.run();
        }
    }
}
