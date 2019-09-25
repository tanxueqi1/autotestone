package com.autoframework.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoggerController {

    private static Logger logger=null;
    private static LoggerController logg;

    public static LoggerController getLogger(Class<?> T){
        if(logger==null){
            //实例化Properties类，处理.properties格式的文件
            Properties properties = new Properties();
            try {
                String path=System.getProperty("user.dir");
                String filePath=path+"/config/log4j.properties";
                InputStream is = new FileInputStream(filePath);
                properties.load(is);
            }catch (Exception e){
                e.printStackTrace();
            }
            PropertyConfigurator.configure(properties);
            logger=Logger.getLogger(T);
            logg=new LoggerController();
        }
        return logg;
    }

    public void debug(String msg){
        logger.debug(msg);
    }
    public void info(String msg){
        logger.info(msg);
    }
    public void warn(String msg){
        logger.warn(msg);
    }
    public void error(String msg){
        logger.error(msg);
    }

}
