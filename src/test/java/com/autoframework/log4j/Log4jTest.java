package com.autoframework.log4j;

import com.autoframework.logger.LoggerController;
import org.testng.annotations.Test;

public class Log4jTest {

    final static LoggerController log=LoggerController.getLogger(Log4jTest.class);

    @Test
    public void testCase(){
        log.debug("这是debug");
        log.info("这是info");
        log.warn("这是warn");
        log.error("这是error");
    }
}
