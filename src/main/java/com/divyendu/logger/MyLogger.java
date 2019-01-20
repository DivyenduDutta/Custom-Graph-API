package com.divyendu.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.divyendu.logger.formatter.MyFormatter;
import com.divyendu.queue.Queue;

public class MyLogger {
	private Logger logger = Logger.getLogger(MyLogger.class.getName());	//get logger instance
	private LogManager logManager = LogManager.getLogManager();
	
	public MyLogger() {
		try {
			logManager.readConfiguration(Queue.class.getResourceAsStream("/mylogging.properties"));
			logger.setLevel(Level.FINE);
			logger.setUseParentHandlers(false);
			ConsoleHandler conHandler = new ConsoleHandler();
			conHandler.setFormatter(new MyFormatter());
		    logger.addHandler(conHandler);
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}

	public Logger getLogger() {
		return logger;
	}
	
}
