package com.my.loggerTest;

import java.util.logging.Logger;

import com.my.logger.LoggerService;
import com.my.logger.LoggerServiceImpl;

public class loggerTestByjar {

	public static void main(String[] args) {
		LoggerService loggerService = new LoggerServiceImpl();
		Logger logger = loggerService.getLoggerConsoleAndFile(loggerTestByjar.class.getName());
		logger.info("haha1");

	}

}
