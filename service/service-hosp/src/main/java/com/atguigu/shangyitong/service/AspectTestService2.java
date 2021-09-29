package com.atguigu.shangyitong.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AspectTestService2 {

    public void insert() throws Exception{
        log.info("this is AspectTestService2 insert()");
    }

    public void delete() throws Exception{
        log.info("this is AspectTestService2 delete()");
    }

    public void update() throws Exception{
        log.info("this is AspectTestService2 update()");
    }

    public void find() throws Exception{
        log.info("this is AspectTestService2 find()");
    }

}
