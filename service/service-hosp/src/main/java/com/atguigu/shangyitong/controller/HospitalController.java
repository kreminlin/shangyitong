package com.atguigu.shangyitong.controller;


import com.atguigu.shangyitong.annotation.AdminOnly;
import com.atguigu.shangyitong.entity.HospitalSet;
import com.atguigu.shangyitong.service.HospitalSetService;
import com.atguigu.shangyitong.vo.HospitalSetVo;
import com.atguigu.yygh.result.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/hosp")
public class HospitalController {

    @Autowired
    private HospitalSetService hospitalSetService;

    //查询医院所有信息
    @AdminOnly
    @ApiOperation(value = "查询所有医院信息")
    @GetMapping(value = "/findAll")
    public Result findAll() {
//        try {
//            int i = 1/0;
//        }catch (Exception e){
//            throw new YyghException("失败",201);
//        }
        List<HospitalSet> hospitalSets = hospitalSetService.list();
        return Result.ok(hospitalSets);
    }

    //根据Id删除
    @ApiOperation(value = "根据Id删除医院信息")
    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable long id) {
        boolean flag = hospitalSetService.removeById(id);
        return Result.ok(flag);
    }

    //条件查询--带分页接口
    @ApiOperation(value = "分页查询")
    @PostMapping(value = "/findPageHospSet/{current}/{limit}")
    public Result findPageHospSet(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) HospitalSetVo hospitalSetVo) {
        //创建page对象，传递当前页，每页记录数
        Page<HospitalSet> page = new Page<>(current, limit);
        //构造条件
        QueryWrapper queryWrapper = new QueryWrapper();
        String hosname = hospitalSetVo.getHosname();
        String hoscode = hospitalSetVo.getHoscode();
        if (!StringUtils.isEmpty(hosname)) {
            queryWrapper.like("hosname", hospitalSetVo.getHosname());
        }
        if (!StringUtils.isEmpty(hoscode)) {
            queryWrapper.eq("hocode", hospitalSetVo.getHoscode());
        }
        //调用方法实现分页
        IPage<HospitalSet> getPage = hospitalSetService.page(page, queryWrapper);
        return Result.ok(getPage);
    }

    //添加医院设置
    @ApiOperation(value = "添加医院设置")
    @PostMapping(value = "/saveHospitalSet")
    public String saveHospitalSet(@RequestBody @Valid HospitalSet hospitalSet, BindingResult bindingResult) {
        //设置状态 1使用，0不能使用
//        hospitalSet.setStatus(1);
//        //签名密钥
//        Random random = new Random();
//        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000)));

        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        //调用service
//        boolean save = hospitalSetService.save(hospitalSet);
//        if (save) {
//            return Result.ok();
//        } else {
//            return Result.fail();
//        }
        return "ok";

    }

    //修改医院设置
    @ApiOperation(value = "修改医院设置")
    @PostMapping(value = "/updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //批量删除医院设置
    @ApiOperation(value = "批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> idList) {
        return Result.ok(hospitalSetService.removeByIds(idList));
    }

    //医院设置锁定和解锁
    @PutMapping("lockHospitalSet/{id}/{status}")
    @ApiOperation(value = "医院设置锁定和解锁")
    public Result lockHospitalSet(@PathVariable Long id, @PathVariable Integer status) {
        //根据Id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //设置状态
        hospitalSet.setStatus(status);
        //调用方法
        return Result.ok(hospitalSetService.updateById(hospitalSet));
    }

    //发送签名密钥
    @PutMapping("sendKey/{id}")
    @ApiOperation(value = "sendKey")
    public Result sendKey(@PathVariable Long id) {
        //根据Id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        //TODO 发送短信
        return Result.ok();
    }
}
