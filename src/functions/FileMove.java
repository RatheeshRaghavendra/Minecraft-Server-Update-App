package functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import logger.CustomLogger;

public class FileMove {
    
    Path origin;
    Path target;

    // Initializing the Logger
    CustomLogger customLogger = new CustomLogger();
    Logger logger = customLogger.returnLogger(FileMove.class.getName());

    public FileMove(){
        
    }

    public void moveFiles(Path origin,Path target){
        
        boolean originExists = Files.exists(origin);
        boolean targetExists = Files.exists(target);

        if(originExists && targetExists){

            logger.info("The Origin and Target folders exist");

            // Make a list of files that are to be moved from Origin to Target folder
            List<String> filesToMove = new ArrayList<String>();

            filesToMove.add("/world");
            filesToMove.add("/banned-ips.json");
            filesToMove.add("/banned-players.json");
            filesToMove.add("/ops.json");
            filesToMove.add("/server.properties");
            filesToMove.add("/usercache.json");
            filesToMove.add("/whitelist.json");
            
            // Moving the Files/Folders one by one to the Target folder
            for (String file : filesToMove){
                
                try {
    
                    Path from = Paths.get(origin + file);
                    Path to = Paths.get(target + file);
                    Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
                    logger.info(file + " moved successfully from: " + from + ". To: " + to);

                } catch (IOException e) {

                    logger.severe("'" + file + "' hasn't been moved. Failed with the error '" + e.toString() + "'");

                }
            }

            // Updating the End User License Agreement value to true (Agree)
            Path eula = Paths.get(target + "/eula.txt");
            List<String> lines = new ArrayList<String>();

            try {

                lines = Files.readAllLines(eula);
                int index = lines.lastIndexOf("eula=false");
                lines.remove(index);
                lines.add("eula=true");
                Files.write(eula,lines);
                logger.info("eula has been agreed (the value is now true)");

            } catch (IOException e) {

                logger.severe("eula hasn't been agreed (the value is still false). Failed with the error '" + e.toString() + "'");

            }
        }
        else{

            logger.severe("Either Orign folder or Target folder doesn't exist. Does Orgin folder exist? " + originExists + ". Does Target folder exist? " + targetExists);

        }

    }
}
