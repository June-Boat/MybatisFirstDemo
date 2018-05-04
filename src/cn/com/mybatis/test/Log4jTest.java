package cn.com.mybatis.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Test;

public class Log4jTest {
	private Logger logger= LogManager.getLogger("Log4jTest");
	
	public static void main(String[] args) {  
	    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");  
	}  
	
/*	@Test
	public void testC3p0(){
		logger.info("这是一个log4j的info日志");
	}*/
}
