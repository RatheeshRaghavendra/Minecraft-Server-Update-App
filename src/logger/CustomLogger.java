package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class CustomLogger {
    
    String loggerName;

    public CustomLogger(){

    }

    public Logger returnLogger(String loggerName){

        Logger logger = Logger.getLogger(loggerName);
        logger.setUseParentHandlers(false);
        
        LogFormater formatter = new LogFormater();
        ConsoleHandler handler = new ConsoleHandler();

        handler.setFormatter(formatter);
        logger.addHandler(handler);

        return logger;

    }

}
