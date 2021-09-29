package com.atguigu.shangyitong.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {

    private final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test(){
        /*logger.info("这是info级别的日志");
        logger.debug("这是debug级别的日志");
        logger.error("这是error级别的日志");*/
        log.info("这是info级别的日志");
        log.debug("这是debug级别的日志");
        log.error("这是error级别的日志");
    }

}
