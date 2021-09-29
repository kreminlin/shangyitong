package com.atguigu.shangyitong.controller;

import com.atguigu.shangyitong.vo.ParamVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author lzh
 */
@RestController
public class TestConlloer {
    /**
     * @param
     * @return
     */
    @PostMapping("/value")
    public String run(@Valid @RequestBody ParamVo user, BindingResult result){
        if(result.hasErrors()) return result.getAllErrors().toString();
        return user.toString();
    }

}
