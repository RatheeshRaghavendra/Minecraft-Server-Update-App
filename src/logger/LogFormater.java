package logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormater extends Formatter {
    
    @Override
    public String format(LogRecord record){

        return record.getLevel()+"::"+new Date(record.getMillis())+"::"+record.getThreadID()+"::"+record.getSourceClassName()+"::"+record.getSourceMethodName()+":: "+record.getMessage()+"\n";
    }
}
