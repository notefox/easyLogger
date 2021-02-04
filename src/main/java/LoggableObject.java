import java.io.File;
import java.io.IOException;

/**
 * loggable object frame
 */
public class LoggableObject {

    /**
     * logger used
     */
    private final Logger logger;

    /**
     * Object tag
     */
    private final String tag;

    /**
     * constructor
     * @param tag class tag for LogEntry
     * @param filePrefix logfile prefix
     * @param logDefaultDir logger default directory
     * @param maxLogFileSize max log file size in MB
     * @param logTerminalOutput System.out::print bit
     * @throws IOException is thrown, if the logger has problems with the given file path
     */
    public LoggableObject(String tag, String filePrefix, File logDefaultDir, int maxLogFileSize, boolean logTerminalOutput) throws IOException {
        this.tag = tag;
        this.logger = new Logger(filePrefix, logDefaultDir, maxLogFileSize, logTerminalOutput);
        this.logger.start();
    }

    /**
     * log method for class
     * @param type log type
     * @param message log message
     */
    protected void log(LogType type, String message) {
        if (logger == null) {
            // ignore
            return;
        }
        logger.addLogEntry(type, tag, message);
    }

    /**
     * log error
     * @param message message
     */
    protected void error(String message) {
        log(LogType.ERROR, message);
    }

    /**
     * log message
     * @param message message
     */
    protected void message(String message) {
        log(LogType.MESSAGE, message);
    }

    /**
     * log info
     * @param message message
     */
    protected void info(String message) {
        log(LogType.INFO, message);
    }

    /**
     * log debug
     * @param message message
     */
    protected void debug(String message) {
        log(LogType.DEBUG, message);
    }

    /**
     * log warning
     * @param message message
     */
    protected void warning(String message) {
        log(LogType.WARNING, message);
    }

    /**
     * log fatal
     * @param message message
     */
    protected void fatal(String message) {
        log(LogType.FATAL, message);
    }
}
