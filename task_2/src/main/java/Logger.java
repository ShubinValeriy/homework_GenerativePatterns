public class Logger {
    protected int num = 1;

    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
        System.out.println("[" + dateTime + " " + num++ + "] " + msg);
    }
}
