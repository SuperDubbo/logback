package com.hz.logback.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import com.hz.logback.LogUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    @Before
    public void before() throws JoranException {
        //加载日志文件
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        configurator.doConfigure("src/main/resources/logback.xml");
//        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
        StatusPrinter.print(lc);
    }


    @Test
    public void test1() {
        LogUtils.customLog("自定义");
        LogUtils.logInfo("INFO ~");
        LogUtils.logDebug("DEBUG ~");
        LogUtils.logError("ERROR~");
        LogUtils.logWarn("WARN ~");
    }
}
