package com.atguigu.shangyitong.controller;

import com.atguigu.shangyitong.entity.HospitalSet;
import com.atguigu.shangyitong.service.HospitalSetService;
import com.atguigu.shangyitong.vo.HospitalSetVo;
import com.atguigu.yygh.result.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class HospitalControllerTest {

    @Autowired
    TestRestTemplate testTemplate;

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    protected WebApplicationContext wac;

    private HospitalSetVo hospitalSetVo;

    private MockMvc mvc;

    private List<HospitalSet> hospitalSets;

    @Before
    public void setUp() throws Exception {
        hospitalSetService = Mockito.mock(HospitalSetService.class);
//        hospitalSetVo = new HospitalSetVo();
        Mockito.when(hospitalSetService.list()).thenReturn(hospitalSets);
//        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @After
    public void teardown() throws Exception {
        System.out.println("this is after");

    }

    @Test
    public void findAll() {
        String uri = "http://localhost:8202/hosp/findAll";
        URI url = URI.create(uri);
        Result result =  testTemplate.getForObject(url,Result.class);
        System.out.println(result);
    }

    @Test
    void removeHospSet() {
    }

    @Test
    void findPageHospSet() {
    }

    @Test
    void saveHospitalSet() {
    }

    @Test
    void updateHospitalSet() {
    }
}