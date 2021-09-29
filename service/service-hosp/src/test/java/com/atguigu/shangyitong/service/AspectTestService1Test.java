package com.atguigu.shangyitong.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AspectTestService1Test {

    @Autowired
    AspectTestService1 aspectTestService1;

    @Autowired
    AspectTestService2 aspectTestService2;

    @Autowired
    AspectTestService3 aspectTestService3;

    @Test
    void insert() throws Exception {
        aspectTestService1.insert();
        aspectTestService2.insert();
        aspectTestService3.insert();

        aspectTestService1.update();
        aspectTestService2.update();
        aspectTestService3.update();

        aspectTestService1.delete();
        aspectTestService2.delete();
        aspectTestService3.delete();

        aspectTestService1.find();
        aspectTestService2.find();
        aspectTestService3.find();
    }

}