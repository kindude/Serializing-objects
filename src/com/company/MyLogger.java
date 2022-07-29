package com.company;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    static Logger logger;
    public FileHandler fileHandler;
    public SimpleFormatter formatter;

    private MyLogger() throws IOException{
        logger =  Logger.getLogger(Handler.class.getName());
        fileHandler =  new FileHandler("log.txt", true);
        formatter = new SimpleFormatter();
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

    }

    private static Logger getLogger(){
        if(logger == null) {
            try {
                new MyLogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }
    public static void log(Level level, String msg){
        getLogger().log(level,msg);
    }

}
