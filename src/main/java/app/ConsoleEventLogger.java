package app;

public class ConsoleEventLogger implements EventLogger {


    public void logEvent(String msg) {
        System.out.println("Got this message: " + msg);
    }
}
