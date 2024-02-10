import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import functions.FileMove;
import logger.CustomLogger;

public class MinecraftServerUpdate {
    public static void main(String[] args) throws Exception {

        // Initializing the Logger
        CustomLogger customLogger = new CustomLogger();
        Logger logger = customLogger.returnLogger(MinecraftServerUpdate.class.getName());

        // Start of the Process
        logger.info("Process Start");

        // Getting the Origin and Target folder
        String originArg = args[1];
        String targetArg = args[3];

        // Initializing the FileMove class
        FileMove fm = new FileMove();
        
        // Setting Orgin and Target folder
        Path  origin = Paths.get(originArg);
        Path  target = Paths.get(targetArg);
        logger.info("Origin: " + origin + " Target: " + target);
        
        // Moving the files from Origin to Target folder
        fm.moveFiles(origin,target);

        // Completion of the Process
        logger.info("The Process has been completed");
    }
}
