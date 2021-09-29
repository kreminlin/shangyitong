package com.atguigu.shangyitong.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AspectTestService1 {

    public void insert() throws Exception{
        log.info("this is AspectTestService1 insert()");
//        throw new Exception("人为抛出异常！");
    }

    public void delete() throws Exception{
        log.info("this is AspectTestService1 delete()");
    }

    public void update() throws Exception{
        log.info("this is AspectTestService1 update()");
    }

    public void find() throws Exception{
        log.info("this is AspectTestService1 find()");
    }

}
