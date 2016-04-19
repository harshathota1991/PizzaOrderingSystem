

package com.gsu.pos.util;


import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class LogFile {

	public static final Logger logger;
	static {
		logger = Logger.getLogger(LogFile.class.getName());
		try {
			FileHandler fileHandler = new FileHandler("c:\\LogFiles\\app.log",
					true);
			logger.addHandler(fileHandler);
			Formatter formater = getCustomFormatter();
			fileHandler.setFormatter(formater);
		} catch (IOException exception1) {
			logger.log(Level.SEVERE, "asasasasa", exception1);
		}
	}
	
	public static Formatter getCustomFormatter () {
		return new Formatter() {

			@Override
			public String format (final LogRecord record) {
				String recordStr = "{Date} " + new Date() + " {Log Level} "
						+ record.getLevel() + " {Class} "
						+ record.getSourceClassName() + " {Method} "
						+ record.getSourceMethodName() + " {Message} "
						+ record.getMessage() + "\n";
				return recordStr;
			}
		};
	}
	
	public static void logging (final Exception exception, final String message) {
		logger.log(Level.SEVERE, message, exception);
	}
}
